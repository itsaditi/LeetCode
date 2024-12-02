class Solution {
    public void nextPermutation(int[] nums) {
        // Single Pass Approach - 
        // 1. Starting from right to left, find first decreasing element.
        // 2. Starting from right to left, find element number just larger than decreasing element
        //    and swap first decreasing element with this one

        int n = nums.length - 2;

        // Find decreasing element
        while (n >= 0 && nums[n + 1] <= nums[n]) {
            n--;
        }

        if (n >= 0) {
            int m = nums.length - 1;
            while (nums[m] <= nums[n]) {
                m--;
            }
            swap(nums, n, m);
        }

        reverse(nums, n + 1);
        
    }

    private void reverse(int[] num, int start) {
        int end = num.length - 1;
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }

    }

    private void swap (int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}