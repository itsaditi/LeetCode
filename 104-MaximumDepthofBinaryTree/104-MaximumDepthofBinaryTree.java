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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        maxDepth = Math.max(maxDepth, level);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


}