import java.util.*;
public class NumberOfIslandsDFS {
    void dfs(char[][] grid, int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }

        grid[i][j] = 2;

        // left
        dfs(grid, n, m, i - 1, j);

        // right
        dfs(grid, n, m, i + 1, j);

        // up
        dfs(grid, n, m, i, j - 1);

        // down
        dfs(grid, n, m, i, j + 1);

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
                    System.out.println("Hi");
                    dfs(grid, n, m, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
