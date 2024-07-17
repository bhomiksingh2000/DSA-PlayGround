// https://leetcode.com/problems/my-calendar-i/

public class MyCalendar {

    public class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }

    }

    public boolean check(TreeNode parent, int s, int e) {

        if (parent.start >= e) {
            // means it can be in left part of parent, checking

            if (parent.left == null) {
                parent.left = new TreeNode(s, e);
                return true;
            }

            else {
                return check(parent.left, s, e);
            }

        }

        else if (parent.end <= s) {
            // means it can be in right part of parent, checking
            if (parent.right == null) {
                parent.right = new TreeNode(s, e);
                return true;
            }

            else {
                return check(parent.right, s, e);
            }
        }

        /* now if start of the node is not greater than equal to parent.start
        means right part mai nhi ho skta


        and end of the node is not smaller than equal to root ,
        means left part mai nhi ho skta

        this means that , the node can not be in either the left or the right ,
        this means this can not be inserted in BST


        */
        else {
            return false;
        }
    }

    TreeNode root = null;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            // 1st node created
            root = new TreeNode(start, end);
            return true;
        }

        else {
            return check(root, start, end);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
