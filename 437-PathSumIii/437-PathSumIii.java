// Last updated: 4/21/2026, 8:52:24 PM
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
    
    int pathCount = 0;
    HashMap<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return 0;
        traversal(root, targetSum, 0L);
        return pathCount;
    }

    private void traversal(TreeNode root, int targetSum, long currentPath){

        if(root == null) return;

        currentPath += root.val;

        if(currentPath == targetSum) pathCount++;

        // The number of times the curr_sum − k has occurred already, 
        // determines the number of times a path with sum k 
        // has occurred up to the current node
        pathCount += map.getOrDefault(currentPath - targetSum, 0);
        
        //Add the current sum into the hashmap
        // to use it during the child node's processing
        map.put(currentPath, map.getOrDefault(currentPath, 0) + 1);

        traversal(root.left, targetSum, currentPath);
        traversal(root.right, targetSum, currentPath);

        map.put(currentPath, map.get(currentPath) - 1);
    }
}