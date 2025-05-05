// Last updated: 5/5/2025, 6:44:51 PM
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
 // FIX THE
class Solution {

    // Time Complexity - O(NLogN)
    // Space Complexity - O(N)
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0,0, root);

        for (Integer key: map.keySet()) {
            // Get Column
            TreeMap<Integer, List<Integer>> treeMap = map.get(key);
            List<Integer> res = new ArrayList<>();

            for (Integer treeMapKey: treeMap.keySet()) {
                List<Integer> ls = treeMap.get(treeMapKey);
                Collections.sort(ls);
                res.addAll(ls);
            }
            result.add(res);

        }


        System.out.println(map);
        return result;
    }

    private void dfs(int row, int col, TreeNode root) {
        if (root == null) return;

        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<>());
        }

        map.get(col).get(row).add(root.val);

        dfs(row + 1, col - 1, root.left);
        dfs(row + 1, col + 1, root.right);
    }
}