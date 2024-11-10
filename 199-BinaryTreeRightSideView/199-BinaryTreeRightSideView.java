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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0);

        for (int i = 0 ; i < map.size() ; i ++) {
            res.add(map.get(i).get(map.get(i).size()-1));
        }


        System.out.print(map);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        
        if (root.left != null)
            dfs(root.left, level + 1);
        
        if (root.right != null)
            dfs(root.right,level + 1);

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }

        map.get(level).add(root.val);

    }
}