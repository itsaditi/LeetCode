// Last updated: 6/18/2025, 9:55:42 PM
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
    /**
                3
                ^ 
            9       20
                    ^
                15      7
        Left-most leaf = 9 | depth = 1 (0-indexed Depth)
        Right-most leaft = 7 | dept = 2
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // Check if subtrees have height within 1 --> Math.abs(height(root.left) - height(root.right))
        // And check if subtrees are balanced --> isBalanced recurssion
        // return Math.abs(height(root.left) - height(root.right)) < 2 &&
        //         isBalanced(root.left) && isBalanced(root.right); 

        return checkHeight(root) != -1;

    }

    private int height(TreeNode root) {
        if (root == null) return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }


private int checkHeight(TreeNode node) {
    if (node == null) return 0;

    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) return -1; // left subtree unbalanced

    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) return -1; // right subtree unbalanced

    if (Math.abs(leftHeight - rightHeight) > 1) return -1; // current node unbalanced

    return 1 + Math.max(leftHeight, rightHeight); // height of this node
}


}