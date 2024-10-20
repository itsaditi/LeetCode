class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1 ;

        while (start <= end) {
            int midIndex = (end + start) / 2;

            if (nums[midIndex] == target) return midIndex;
            else {
                if (nums[midIndex] >= nums[start]) {
                    if (target >= nums[start] && target < nums[midIndex]) {
                        end = midIndex - 1;
                    } else {
                        start = midIndex + 1;
                    }
                } else {
                    if (target <= nums[end] && target > nums[midIndex]) {
                        start = midIndex + 1;
                    } else {
                        end = midIndex - 1;
                    }
                }
            }
        }

        return -1;
    }
}