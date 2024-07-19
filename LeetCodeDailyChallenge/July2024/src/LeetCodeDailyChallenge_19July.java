import java.util.*;
public class LeetCodeDailyChallenge_19July {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int minEle = Integer.MAX_VALUE;

            for(int j = 0; j < m; j++){
                minEle = Math.min(minEle, matrix[i][j]);
            }

            mp.put(minEle, 1);
        }


        for(int i = 0; i < m; i++){
            int maxEle = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                maxEle = Math.max(maxEle, matrix[j][i]);
            }

            if(mp.containsKey(maxEle)){
                res.add(maxEle);

            }
        }

        return res;
    }
}
