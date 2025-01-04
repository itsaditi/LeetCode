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
    int minDepth = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
        if (root == null) return 0;

		// Traverse root with level
		traverse(root, 0);	
		return minDepth + 1;
    }

    private void traverse (TreeNode root, int level) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, level);
        }
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
        return;
    }

}