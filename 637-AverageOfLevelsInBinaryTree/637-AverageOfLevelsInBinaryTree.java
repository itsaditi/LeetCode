// Last updated: 8/4/2025, 4:51:00 PM
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

    List<Double> sum = new ArrayList<>();
    List<Integer> numOfNodes = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result = new ArrayList<>();
        levelTraversal(root, 0);

        for(int i = 0; i < sum.size(); i++){
            double avg = sum.get(i) / numOfNodes.get(i);
           result.add(avg);
        }
        return result;
    }

    private void levelTraversal(TreeNode root, int level){

        if(root == null) return;

        if(sum.size() <= level){
            sum.add(0.0);
            numOfNodes.add(0);
        }

        double currSum = sum.get(level);
        int currCount = numOfNodes.get(level);

        sum.set(level, currSum + root.val);
        numOfNodes.set(level, currCount + 1);


        levelTraversal(root.left, level + 1);
        levelTraversal(root.right, level + 1);
    }
}