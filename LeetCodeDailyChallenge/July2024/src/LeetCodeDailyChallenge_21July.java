public class LeetCodeDailyChallenge_21July {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;

        int [][] res = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rowSum[i] == 0){
                    continue;
                }

                else{
                    if(rowSum[i] <= colSum[j]){
                        res[i][j] = rowSum[i];
                        rowSum[i] -= res[i][j];
                        colSum[j] -= res[i][j];
                    }

                    else{
                        res[i][j] = colSum[j];
                        colSum[j] -= res[i][j];
                        rowSum[i] -= res[i][j];
                    }
                }
            }
        }

        return res;
    }
}
