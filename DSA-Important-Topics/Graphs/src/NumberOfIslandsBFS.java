import java.util.*;
public class NumberOfIslandsBFS {
    class Solution {
        class Pair {
            int first;
            int second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        void bfs(char[][] grid, int i, int j, int n, int m) {
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(i, j));

            while (q.size() > 0) {
                int row = q.peek().first;
                int col = q.peek().second;

                q.poll();

                if (row - 1 >= 0 && grid[row - 1][col] != 0 && grid[row - 1][col] != 2) {
                    grid[row - 1][col] = 2;
                    q.add(new Pair(row - 1, col));
                }

                if (row + 1 < n && grid[row + 1][col] != 0 && grid[row + 1][col] != 2) {
                    grid[row + 1][col] = 2;
                    q.add(new Pair(row + 1, col));
                }

                if (col - 1 >= 0 && grid[row][col - 1] != 0 && grid[row][col - 1] != 2) {
                    grid[row][col - 1] = 2;
                    q.add(new Pair(row, col - 1));
                }

                if (col + 1 < m && grid[row][col + 1] != 0 && grid[row][col + 1] != 2) {
                    grid[row][col + 1] = 2;
                    q.add(new Pair(row, col + 1));
                }

            }
        }

        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1')
                        grid[i][j] = 1;
                    else
                        grid[i][j] = 0;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        bfs(grid, i, j, n, m);
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
