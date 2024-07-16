public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    // constructor
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
