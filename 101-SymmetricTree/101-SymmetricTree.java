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
    public boolean isSymmetric(TreeNode root) {
        if ((root.left == null && root.right == null)) return true;
        
        if (root.right == null || root.left == null) return false;

        if (root.left.val != root.right.val) return false;


        return dfs(root.left, root.right);
    }



    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || ( p != null && q == null)) {
            return false;
        }

        // if ((p.left.val != q.right.val) && (p.right.val != q.left.val)) {
        //     return false;
        // }

        if (p.val != q.val) {
            return false;
        }  

        int left = dfs(p.left, q.right) ? 1 : 0;
        int right = dfs(p.right, q.left) ? 1 : 0;

        return (left + right) == 2;
        
    }
}