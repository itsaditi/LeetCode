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
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair popElem = queue.poll();

            TreeNode node = (TreeNode) popElem.getKey();
            int level = (int) popElem.getValue();

            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }


            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }

            maxDepth = Math.max(maxDepth, level);
        }

        return maxDepth + 1;

    }


    public int maxDepth_UsingDFS(TreeNode root) {
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