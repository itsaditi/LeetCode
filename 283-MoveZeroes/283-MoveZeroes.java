class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int num: nums) {
            if (num == 0) zeroCount ++;
        }

        if (zeroCount == 0) return;

        for (int i = 0 ; i < nums.length - zeroCount ; i ++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                swap(nums, i, j);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}