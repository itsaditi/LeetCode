class Solution {
    public int[] sortedSquares(int[] nums) {

        // Remove negavtive sign
        for (int i = 0 ; i < nums.length ; i ++) {
            nums[i] = nums[i] < 0 ? (0 - nums[i]) : nums[i];
        }

        // Sort Array
        Arrays.sort(nums);

        // Square in-place
        for (int i = 0 ; i < nums.length ; i ++) {
            nums[i] = nums[i] * nums[i];
        }

        return nums;
    }
}