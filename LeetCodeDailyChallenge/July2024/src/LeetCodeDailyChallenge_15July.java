public class LeetCodeDailyChallenge_15July {
    // c++ code

    /*
    TreeNode* buildTree(TreeNode* root,
                        unordered_map<int, vector<int>>& childrenOfEachNode) {
        if (!root ||
            childrenOfEachNode.find(root->val) == childrenOfEachNode.end()) {
            return root;
        }

        vector<int>& children = childrenOfEachNode[root->val];

        if (children[0] != 0) { // 0 is used to denote no child
            TreeNode* leftChild = new TreeNode(children[0]);
            root->left = buildTree(leftChild, childrenOfEachNode);
        }

        if (children[1] != 0) { // 0 is used to denote no child
            TreeNode* rightChild = new TreeNode(children[1]);
            root->right = buildTree(rightChild, childrenOfEachNode);
        }

        return root;
    }

public:
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, vector<int>> childrenOfEachNode;
        unordered_set<int> allChildren;

        // Populate the childrenOfEachNode and mark all children
        for (const auto& desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            bool isLeft = desc[2];

            if (childrenOfEachNode.find(parent) == childrenOfEachNode.end()) {
                childrenOfEachNode[parent] =
                    vector<int>(2, 0); // Initialize with 0
            }

            if (isLeft) {
                childrenOfEachNode[parent][0] = child;
            } else {
                childrenOfEachNode[parent][1] = child;
            }

            allChildren.insert(child);
        }

        // Determine the root
        TreeNode* root = nullptr;
        for (const auto& desc : descriptions) {
            int parent = desc[0];
            if (allChildren.find(parent) == allChildren.end()) {
                root = new TreeNode(parent);
                break;
            }
        }

        // Build the tree
        return buildTree(root, childrenOfEachNode);
    }
     */
}
