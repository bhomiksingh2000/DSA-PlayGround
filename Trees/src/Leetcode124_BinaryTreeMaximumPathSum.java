public class Leetcode124_BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;

    int util(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0,util(root.left));      // if left part is negative no need to include it
        int right = Math.max(0,util(root.right));    // if right part is negative do need to include it

        int sum = Math.max(root.val + left, root.val + right);

        ans = Math.max(ans, sum);
        ans = Math.max(ans, root.val + left + right);
        ans = Math.max(ans, root.val);

        return sum;
    }

    public int maxPathSum(TreeNode root) {

        util(root);

        return ans;

    }
}
