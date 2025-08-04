// Last updated: 8/4/2025, 4:50:43 PM
class Solution {
    /**** TWO POINTER ****/
    // O(n)
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        int maxWidth = 0;

        // Set last element of rightMax to last element of nums
        rightMax[n - 1] = nums[n - 1];

        // Iterate over nums and set rightMax[i] to be max of 
        // nums[i] and rightMax[i + 1]
        // To ensure that rightMax contains highest value from
        // index i to end of the original array
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        // Initialize left and right pointer
        int left = 0, right = 0;

        while (right < n) {
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, (right - left));
            right++;    
        }

        return maxWidth;
    }




    /**** SORTING ****/
    // TC - O(n log n)
    /*
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        // Fill indices array with 0 to n-1
        for (int i = 0 ; i < n ; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in nums
        Arrays.sort(indices, (i, j) -> 
            nums[i] != nums[j] ? (nums[i] - nums[j]) : i - j
        );

        // Initialize maxWith and minIndex
        int maxWidth = 0, minIndex = n;

        for (int i: indices) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }        
        return maxWidth;
    }
    */
}