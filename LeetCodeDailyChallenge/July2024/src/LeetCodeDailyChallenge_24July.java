import java.util.*;
public class LeetCodeDailyChallenge_24July {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            mp.put(i, mapping[i]);
        }

        // A list to hold transformed numbers and their original indices
        TreeMap<Long, List<Integer>> finalMp = new TreeMap<>();
        for (int num : nums) {
            int temp = num;
            long res = 0;
            int place = 1;

            // Handle zero case explicitly
            if (temp == 0) {
                res = mp.get(0);
            } else {
                // Extract each digit and map it
                while (temp > 0) {
                    int digit = temp % 10;
                    temp = temp / 10;

                    res = res + mp.get(digit) * place;
                    place *= 10;
                }
            }

            // Put the transformed number and the original number
            finalMp.computeIfAbsent(res, k -> new ArrayList<>()).add(num);
        }

        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Long, List<Integer>> entry : finalMp.entrySet()) {
            ansList.addAll(entry.getValue());
        }

        // Convert list to array
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
