import java.util.*;
public class LeetCodeDailyChallenge_12July {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Push the current string to stack and reset temp
                st.push(temp);
                temp = "";
            } else if (c == ')') {
                // Reverse the current string
                temp = new StringBuilder(temp).reverse().toString();
                // Append the reversed string to the string at the top of the stack
                temp = st.pop() + temp;
            } else {
                // Build the current string
                temp += c;
            }
        }

        // Combine all parts to get the final result
        return temp;
    }
}
