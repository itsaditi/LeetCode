/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Pre-order -> RoLR
    // In-order -> LRoR

    int preOrderIndex;
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>(); // Element -> index

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToIndex(preorder, 0, preorder.length - 1);
    }

    // Recursion
    private TreeNode arrayToIndex(int[] preOrder, int left, int right) {
        // When there are no elements left to construct
        if (left > right) return null;

        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToIndex(preOrder, left, inorderIndexMap.get(rootValue) - 1 );

        root.right = arrayToIndex(preOrder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}