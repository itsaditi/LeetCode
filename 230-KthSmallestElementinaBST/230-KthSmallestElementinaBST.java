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
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        int kthSmallest = 0;
        traverseBST(root);

        for (int i = 1 ; i <= k; i++) {
            kthSmallest = heap.poll();
        }

        return kthSmallest;
    }

    private void traverseBST(TreeNode root) {
        if (root == null) return;

        heap.add(root.val);

        traverseBST(root.left);
        traverseBST(root.right);
    }
}