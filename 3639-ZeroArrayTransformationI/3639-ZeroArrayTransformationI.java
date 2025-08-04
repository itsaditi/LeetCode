// Last updated: 8/4/2025, 4:50:07 PM
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // Optimal Solution using difference array
        int[] diffArray = new int[nums.length + 1];

        // Create different array
        for (int i = 0; i < nums.length ; i++) {
            if (i == 0) {
                diffArray[i] = nums[i];
            } else {
                diffArray[i] = nums[i] - nums[i - 1];
            }
        }

        // Update different array -
        // D[start] =- 1 and D[end + 1] += 1
        for (int j = 0 ; j < queries.length ; j++) {
            update(diffArray, queries[j][0], queries[j][1]);
        }

        // num[i] = D[i] + nums[i -1]
        for (int k = 0 ; k < nums.length ; k++) {
            if (k == 0) {
                nums[k] = diffArray[k];
                if (diffArray[k] > 0 ) return false;
            } else {
                nums[k] = diffArray[k] + nums[k - 1];
                if (nums[k] > 0) return false;
            }

        }

        return true;
        
    }

    private void update(int[] num, int start, int end) {
        num[start]--;
        num[end+1]++;
    }

    /**BRUTE FORCE */
    /*
    public boolean isZeroArray(int[] nums, int[][] queries) {

        for (int i = 0 ; i < queries.length ; i++) {
            decrementArray(nums, queries[i][0], queries[i][1]);
        }

        for (int num: nums) {
            if (num != 0) return false;
        }

        return true;
        
    }

    private void decrementArray(int[] num, int start, int end) {
        while (start <= end) {
            if (num[start] != 0) num[start]--;
            start++;
        }
    }
    */
}