import java.util.*;
public class LeetCodeDailyChallenge_29July {
    int utilIncreasing(int[] nums, int n, int i, int prevIndex, int count, int [][][] memo){
        if(count >= 3){
            return 1;
        }

        if(i >= n){
            return 0;
        }

        if(memo[i][prevIndex + 1][count] != -1){
            return memo[i][prevIndex + 1][count];
        }

        int ans1 = 0;
        // include
        if(prevIndex == -1 || nums[i] > nums[prevIndex]){
            ans1 = utilIncreasing(nums, n, i + 1, i, count + 1, memo);
        }

        // not include
        int ans2 = utilIncreasing(nums, n, i + 1, prevIndex, count, memo);

        return  memo[i][prevIndex + 1][count] = ans1 + ans2;

    }
    int utilDecreasing(int[] nums, int n, int i, int prevIndex, int count, int [][][] memo){
        if(count >= 3){
            return 1;
        }

        if(i >= n){
            return 0;
        }

        if(memo[i][prevIndex + 1][count] != -1){
            return memo[i][prevIndex + 1][count];
        }

        int ans1 = 0;
        // include
        if(prevIndex == -1 || nums[i] < nums[prevIndex]){
            ans1 = utilDecreasing(nums, n, i + 1, i, count + 1, memo);
        }

        // not include
        int ans2 = utilDecreasing(nums, n, i + 1, prevIndex, count, memo);

        return memo[i][prevIndex + 1][count] = ans1 + ans2;
    }
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][][] memo = new int[n+1][n+1][4];
        for(int[][] plane: memo) {
            for(int[] row: plane) {
                Arrays.fill(row, -1);
            }
        }

        int res = utilIncreasing(rating, rating.length, 0, -1, 0, memo);

        // fill the memo with -1 again for calculating -1
        for(int[][] plane: memo) {
            for(int[] row: plane) {
                Arrays.fill(row, -1);
            }
        }

        return res + utilDecreasing(rating, rating.length, 0, -1, 0, memo);

    }
}
