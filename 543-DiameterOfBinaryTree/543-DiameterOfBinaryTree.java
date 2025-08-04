// Last updated: 8/4/2025, 4:51:06 PM
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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return diameter;
    }

    private int dfs(TreeNode root) {
        // Reached leaf nodes
        if (root == null) return 0;

        int leftTree = dfs(root.left);
        int rightTree = dfs(root.right);

        diameter = Math.max(diameter, leftTree + rightTree);

        return Math.max(leftTree, rightTree) + 1;


    }
}