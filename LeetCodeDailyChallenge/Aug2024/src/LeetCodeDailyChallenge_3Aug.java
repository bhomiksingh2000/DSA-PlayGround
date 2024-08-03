import java.util.*;
public class LeetCodeDailyChallenge_3Aug {
    public boolean canBeEqual(int[] target, int[] arr) {
        /*

        // METHOD - 1
        if(target.length != arr.length){
            return false;
        }
        Map<Integer, Integer> mpArr = new HashMap<>();
        Map<Integer, Integer> mpTarget = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            mpArr.put(arr[i], mpArr.getOrDefault(arr[i], 0) + 1);
            mpTarget.put(target[i], mpTarget.getOrDefault(target[i], 0) + 1);
        }

        return mpArr.equals(mpTarget);

        */

        // METHOD - 2
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) return false;
        }
        return true;
    }
}
