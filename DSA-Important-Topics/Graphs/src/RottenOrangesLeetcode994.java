import java.util.*;
public class RottenOrangesLeetcode994 {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    int bfs(int[][] grid, Queue<Pair> q, int n, int m){
        int count = 0;
        while(q.size() > 0){
            int size = q.size();
            boolean spread = false;

            for(int k = 0; k < size; k++){
                int i = q.peek().first;
                int j = q.peek().second;
                q.poll();

                if( i - 1 >= 0 && grid[i - 1][j] == 1){
                    q.add(new Pair(i - 1, j));
                    grid[i - 1][j] = 2;
                    spread = true;
                }

                if( i + 1 < n && grid[i + 1][j] == 1){
                    q.add(new Pair(i + 1, j));
                    grid[i + 1][j] = 2;
                    spread = true;
                }

                if( j - 1 >= 0 && grid[i][j - 1] == 1){
                    q.add(new Pair(i, j - 1));
                    grid[i][j - 1] = 2;
                    spread = true;
                }

                if( j + 1 < m && grid[i][j + 1] == 1){
                    q.add(new Pair(i, j + 1));
                    grid[i][j + 1] = 2;
                    spread = true;
                }


            }
            if(spread == true){
                count++;
            }

        }


        // checking the condition if a fresh would have been left
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return count;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
            }
        }

        return bfs(grid, q, n, m);

    }
}
