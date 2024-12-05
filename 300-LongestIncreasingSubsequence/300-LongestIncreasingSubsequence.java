class Solution {
    public int lengthOfLIS(int[] nums) {

        int maxLength = 0;
        int[] increasingSub = new int[nums.length];
        Arrays.fill(increasingSub, 1);

        for (int i = 1 ; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    increasingSub[i] = Math.max(increasingSub[i], increasingSub[j] + 1);
                }
            }
        }

        for (int num: increasingSub) {
            maxLength = Math.max(num, maxLength);
        }
        return maxLength;
    }
}