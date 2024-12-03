class Solution {
    public int subarraySum(int[] nums, int k) {
        int subArrays = 0;
        int target = k;

        for (int num: nums) {
            if (num == k) {
                subArrays++;
            }
        }

        for (int i = 0; i < nums.length ; i ++) {
            int sum = 0;
            sum += nums[i];
            for (int j = i + 1; j < nums.length ; j++) {
                if (sum + nums[j] == k) {
                    subArrays++;
                    // break;
                } 
                sum += nums[j];
                

            }
        }
        return subArrays;
    }
}