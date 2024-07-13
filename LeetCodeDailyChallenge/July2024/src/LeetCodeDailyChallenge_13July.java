
import java.util.*;

public class LeetCodeDailyChallenge_13July {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // First, create a TreeMap to store positions and their corresponding indices
        TreeMap<Integer, Integer> positionMap = new TreeMap<>();
        for (int i = 0; i < positions.length; i++) {
            positionMap.put(positions[i], i);
        }

        Stack<Integer> stack = new Stack<>();

        for (Map.Entry<Integer, Integer> entry : positionMap.entrySet()) {
            int currIndex = entry.getValue();

            if (stack.isEmpty() || directions.charAt(currIndex) == 'R') {
                // If the stack is empty or direction is 'R', push the current index onto the stack
                stack.push(currIndex);
            } else {
                while (!stack.isEmpty() && directions.charAt(stack.peek()) == 'R') {
                    int prevIndex = stack.peek();

                    if (healths[prevIndex] > healths[currIndex]) {
                        healths[currIndex] = 0;
                        healths[prevIndex]--;
                        break;
                    } else if (healths[prevIndex] < healths[currIndex]) {
                        stack.pop();
                        healths[prevIndex] = 0;
                        healths[currIndex]--;
                    } else {
                        stack.pop();
                        healths[prevIndex] = 0;
                        healths[currIndex] = 0;
                        break;
                    }
                }

                // Check if the current robot survived and push it onto the stack if it did
                if (healths[currIndex] > 0) {
                    stack.push(currIndex);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }

        return result;
    }
}
