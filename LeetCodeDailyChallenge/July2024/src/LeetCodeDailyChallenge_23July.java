import java.util.Arrays;
import java.util.*;

public class LeetCodeDailyChallenge_23July {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        // For Java, you need to convert the int to Integer type for using inbuilt sorting techniques.

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, (n1, n2) -> {
            if (freq.get(n1) != freq.get(n2)) {
                // if freq of numbers are not equal then return in increasing order based on
                // freq.
                return freq.get(n1) - freq.get(n2);
            } else {
                // otherwise sort them in decreasing order based on number in nums.
                return n2 - n1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        return nums;
    }
}


/*
without LAMBDA EXPRESSION
METHOD - 1 : USING ANONYMOUS INNER CLASS

Arrays.sort(newNums, new Comparator<Integer>() {
    @Override
    public int compare(Integer n1, Integer n2) {
        if (!freq.get(n1).equals(freq.get(n2))) {
            // Sort in increasing order of frequency
            return freq.get(n1) - freq.get(n2);
        } else {
            // Sort in decreasing order of the numbers
            return n2 - n1;
        }
    }
});


METHOD - 2 : Using a Separate Comparator Class

import java.util.Comparator;

public class FrequencyComparator implements Comparator<Integer> {
    private Map<Integer, Integer> freq;

    public FrequencyComparator(Map<Integer, Integer> freq) {
        this.freq = freq;
    }

    @Override
    public int compare(Integer n1, Integer n2) {
        if (!freq.get(n1).equals(freq.get(n2))) {
            // Sort in increasing order of frequency
            return freq.get(n1) - freq.get(n2);
        } else {
            // Sort in decreasing order of the numbers
            return n2 - n1;
        }
    }
}

 */

