import java.util.*;
public class LeetCodeDailyChallenge_18July {
    int count = 0;
    List<Integer> dfs(TreeNode root, int distance){
        if(root == null){
            return new ArrayList<>();

            // [] would be returned
        }

        if(root.left == null && root.right == null){
            List<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(1);
            return leafDistances;

            // [1] would be returned.
        }

        List<Integer> left_dis = dfs(root.left, distance);
        List<Integer> right_dis = dfs(root.right, distance);

        /*
        now we have got the left and right leaf nodes distances ,
        we will be iterating and checking for each of the leaf nodes
        coming from left with each of the leaf node coming from right
        */

        for(int i = 0; i < left_dis.size(); i++){
            for(int j = 0; j < right_dis.size(); j++){
                if(left_dis.get(i) + right_dis.get(j) <= distance){
                    count++;
                }
            }
        }

        // now we will add 1 to each leaf distances as we are going up
        // and return a merged list

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < left_dis.size(); i++){
            result.add(left_dis.get(i) + 1);
        }

        for(int i = 0; i < right_dis.size(); i++){
            result.add(right_dis.get(i) + 1);
        }

        return result;

    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;

        /*
        the key here is that we have to find the distances of each leaf node
        therefore O(n^3) sol is that :
        in POST ORDER TRAVERSAL we would be returning a list containing
        distance from that particular root , thereofore we would be having a list
        of leaf nodes distances for left part's leaf nodes and right part's leaf node


        now using 2 for loops we would check for each leaf node in left part
        what is the total distance corresponding to each right part leaf node


        for eg from left we have [1, 1] and right part we have [2,3]
        1 + 2 = 3
        1 + 3 = 4

        1 + 2 = 3
        1 + 3 = 5

        now check minimum dis allowed

        after that we would merge the two lists and add 1 to each
        [2, 2, 3, 4] would be returned.
        */

    }

}
