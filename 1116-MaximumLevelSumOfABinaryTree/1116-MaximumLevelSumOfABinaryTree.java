// Last updated: 8/4/2025, 4:50:35 PM
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

    ArrayList<Integer> sum = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        
        int maxSum = Integer.MIN_VALUE;
        int maxIndex = 0;
        levelTraversal(root, 0);

        for(int i = 0; i < sum.size(); i++){
            int currSum = sum.get(i);
            maxSum = Math.max(maxSum, currSum);
        }

        for( int i = 0; i < sum.size(); i++){
            if(maxSum == sum.get(i)){
                maxIndex = i;
                break;
            }
        }
        return maxIndex + 1;
    }

    private void levelTraversal(TreeNode root, int level){

        if(root == null) return;

        while(sum.size() <= level){
            sum.add(0);
        }

        int currSum = sum.get(level);
        sum.set(level, currSum + root.val);

        levelTraversal(root.left, level + 1);
        levelTraversal(root.right, level + 1);

    }
}