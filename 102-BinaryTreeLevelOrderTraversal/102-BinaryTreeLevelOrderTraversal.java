// Last updated: 6/24/2025, 11:09:23 PM
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
    /** BFS (Iteratively using queue) */
    // TC and SC - O(N) where N is the number of nodes in the BT
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>();


        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair poppedElem = queue.poll();
            TreeNode node = (TreeNode) poppedElem.getKey();
            int level = (int) poppedElem.getValue();

            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
            if (!levelMap.containsKey(level)) {
                levelMap.put(level, new ArrayList<>());
            }

            levelMap.get(level).add(node.val);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Integer key: levelMap.keySet()) {
            result.add(levelMap.get(key));
        }

        return result;
    }




    /** DFS ( Using Recursion Stack ) */
    HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
    int levelsFound = 0;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultLevelOrder = new ArrayList<>();
        
        if (root == null) return resultLevelOrder;

        dfs(root, 0);

        for (int i = 0 ; i < levelMap.size(); i ++) {
            resultLevelOrder.add(levelMap.get(i));
        }

        return resultLevelOrder;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new ArrayList<>());
        }
        levelsFound = Math.max(level, levelsFound);

        levelMap.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}