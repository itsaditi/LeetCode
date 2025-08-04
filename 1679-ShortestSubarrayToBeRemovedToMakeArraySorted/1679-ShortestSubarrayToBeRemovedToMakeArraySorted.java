// Last updated: 8/4/2025, 4:50:24 PM
class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {
        
         int n = nums.length;
        int start = 0;
        int end = n - 1;

        // Find the longest non-decreasing prefix
        while (start < n - 1 && nums[start] <= nums[start + 1]) {
            start++;
        }

        // If the entire array is already sorted
        if (start == n - 1) {
            return 0;
        }

        // Find the longest non-decreasing suffix
        while (end > 0 && nums[end] >= nums[end - 1]) {
            end--;
        }

        // Initialize the minimum length of the subarray to be removed
        int minLength = Math.min(n - start - 1, end);

        // Adjust the minimum length by merging prefix and suffix
        int left = 0;
        int right = end;

        while (left <= start && right < n) {
            if (nums[right] >= nums[left]) {
                minLength = Math.min(minLength, right - left - 1);
                left++;
            } else {
                right++;
            }
        }

        return minLength;
    }
}