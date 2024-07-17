import java.util.*;
public class LeetCodeDailyChallenge_17July {
    TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left, toDeleteSet, forest);

        root.right = dfs(root.right, toDeleteSet, forest);

        if (toDeleteSet.contains(root.val)) {
            // now if this node has to be deleted , we must add its childern in the forest
            if (root.left != null) {
                forest.add(root.left);
            }

            if (root.right != null) {
                forest.add(root.right);
            }

            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        // the key here is to understand that post order traversal would work the best
        // here
        // as instead of doing pointer manipulation we could just return null or the
        // value of root
        // to understand that whether this part is to be considered or not

        // think ki post order work karega ya pre order ,
        // because hum yaha pe neehce se set karte aaenge

        /*
         * code would contain two parts here
         *
         * 1st part : settig the pointer
         * 2nd part : collecting the nodes
         */

        Set<Integer> toDeleteSet = new HashSet<>();
        List<TreeNode> forest = new ArrayList<>();

        for (int i = 0; i < to_delete.length; i++) {
            System.out.println(to_delete[i]);
            toDeleteSet.add(to_delete[i]);
        }

        dfs(root, toDeleteSet, forest);

        if (toDeleteSet.contains(root.val) == false) {
            forest.add(root);
        }

        return forest;
    }


/*
 * TC's :
 *
 * [1,2,3,4,5,6,7]
 * [3,5]
 * [1,2,4,null,3]
 * [3]
 * [1]
 * [1]
 * [1, 2, 3, 4, 5, 6, 7, 8, null, null, 9, 10, 11, null, 12]
 * [2, 6, 8, 9, 11]
 * [1, 2, 3, 4, 5]
 * [1]
 * [1, 2, 3, 4, 5, 6, 7, null, null, 8, 9, 10, 11, 12, 13]
 * [1, 3, 5, 12]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * [3,9]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
 * [3, 5, 7, 8, 9, 14]
 *
 */
}
