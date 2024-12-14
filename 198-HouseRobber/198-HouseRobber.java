class Solution {
    int maxAmt = 0;
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];

        Arrays.fill(memo, -1);

        // int n = nums.length;
        // for (int i = 0; i < nums.length ; i++) {
        //     robFrom(nums, nums[i], i);

        // }
        // return maxAmt;

        return robFromRecMemo(nums, 0);
    }

    // Recursion using Memoization
    private int robFromRecMemo(int[] nums, int position) {
        // Base case
        if (position >= nums.length) return 0;

        // Check if cache exists for position
        if (memo[position] > -1) {
            return memo[position];
        }

        int ans = Math.max(
            robFromRecMemo(nums, position + 1),
            robFromRecMemo(nums, position + 2) + nums[position]
        );

        memo[position] = ans;
        return ans;
    }


    // Greedy - TLE (checking all possible combinations)
    private void robFrom(int[] nums, int sum, int nextIndex) {

        if (nextIndex + 2 >= nums.length) {
            maxAmt = Math.max(maxAmt, sum);
            return;
        }

        for (int i = nextIndex + 2 ; i < nums.length ; i++) {
            robFrom(nums, (sum + nums[i]), i);
        }
        
        return;
    }
}