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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);   
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null)) return false;

        if (p.val != q.val) return false;

        int left = dfs(p.left, q.left) ? 1 : 0;
        int right = dfs(p.right, q.right) ? 1 : 0;

        return left + right == 2 ? true : false;
    }
}