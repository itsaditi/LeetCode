// Last updated: 6/26/2025, 12:09:59 AM
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
    ArrayList<Integer> inOrderTraversal = new ArrayList<>();

    // Time and Space Complexity --> O(N)

    public boolean isValidBST(TreeNode root) {        
        dfs(root);
        return isSorted();
        
    }

    private boolean isSorted() {
        for (int i = 0; i < inOrderTraversal.size() - 1; i++) {
            if (inOrderTraversal.get(i) >= inOrderTraversal.get(i+1))
                return false;
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        
        dfs(root.left);
        inOrderTraversal.add(root.val);

        dfs(root.right);
        
    }
}