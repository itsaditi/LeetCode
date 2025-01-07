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
    List<Integer> tree = new ArrayList<>();

    public void flatten(TreeNode root) {
        // Traverse Tree in Pre-order (RoLR) and
        // put all node values in a list
        preOrder(root);
        System.out.println(tree);

        // Create a LinkedList using root
        TreeNode curr = root;

        for (int i = 1; i < tree.size() ; i++) {
            TreeNode newNode = new TreeNode(tree.get(i));
            curr.left = null;
            curr.right = newNode;

            curr = newNode;
        }

    }

    private void preOrder(TreeNode root) {
        if (root == null) return;

        tree.add(root.val);

        preOrder(root.left);
        preOrder(root.right);
    }
}