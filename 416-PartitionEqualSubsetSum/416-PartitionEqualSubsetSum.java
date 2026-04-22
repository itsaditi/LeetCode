// Last updated: 4/21/2026, 8:52:26 PM
class Solution {
    public boolean canPartition(int[] nums) {
          int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = half; i >= num; --i) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[half];
    }
}