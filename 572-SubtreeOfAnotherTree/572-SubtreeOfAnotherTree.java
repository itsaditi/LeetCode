// Last updated: 8/4/2025, 4:51:02 PM
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
    boolean result;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        result = false;
        dfs(root, subRoot);
        return result;
    }

    private void dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return;

        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                result = true;
                return;
            }
        }


        dfs(root.left, subRoot);
        dfs(root.right, subRoot);
        return;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
             return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) return false;

        int left = isSameTree(p.left, q.left) ? 1 : 0;
        int right = isSameTree(p.right, q.right) ? 1 : 0;

        return (left + right) == 2;
    }
}