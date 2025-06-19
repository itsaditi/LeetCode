// Last updated: 6/18/2025, 9:25:37 PM
class Solution {
    public int search(int[] nums, int target) {
        // Edge case
        if (nums.length == 1 && nums[0] == target) return 0;

        int startIndex = 0, endIndex = nums.length - 1;
        int result = -1;

        // Sliding Window
        while(startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;

            if (nums[midIndex] == target) {
                result = midIndex;
                break;
            } else {
                if (target < nums[midIndex]) {
                    endIndex = midIndex - 1;
                    if (endIndex >= 0 && target == nums[endIndex]) {
                        result = endIndex;
                        break;
                    }
                } else if (target > nums[midIndex]) {
                    startIndex = midIndex + 1;
                    if (startIndex <= nums.length - 1 && target == nums[startIndex]) {
                        result = startIndex;
                        break;
                    }
                }
            }

            if (endIndex < 0) break;
            if (startIndex > nums.length - 1) break;
        }

        return result;
        
    }
}