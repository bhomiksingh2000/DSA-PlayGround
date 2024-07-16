public class LeetCodeDailyChallenge_16July {
    TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.val == node1 || root.val == node2) {
            return root;
        }

        TreeNode l = findLCA(root.left, node1, node2);
        TreeNode r = findLCA(root.right, node1, node2);

        if (l == null && r != null) {
            return r;
        }

        else if (l != null && r == null) {
            return l;
        }

        else if (l != null && r != null) {
            return root;
        }

        else {
            return null;
        }
    }

    boolean findPath(TreeNode root, int node, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == node) {
            return true;
        }

        path.append('L');
        if (findPath(root.left, node, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);  // backtrack

        // Check right subtree
        path.append('R');
        if (findPath(root.right, node, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);  // backtrack

        return false;

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();

        findPath(lca, startValue, path1);
        findPath(lca, destValue, path2);

        for (int i = 0; i < path1.length(); i++) {
            path1.setCharAt(i, 'U');

        }

        return path1.append(path2).toString();

    }
}
