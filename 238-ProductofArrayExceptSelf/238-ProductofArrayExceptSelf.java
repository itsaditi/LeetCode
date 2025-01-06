class Solution {
    public int[] productExceptSelf(int[] nums) {
        /** Brute Force */

        // Time complexity --> O(N)
        // Space complexity --> O(1)

        int product = 1;
        int zeros = 0;
        for (Integer num: nums) {
            if (num != 0) {
                product = product * num;
            } else {
                zeros++;
            }
        }

        for (int i = 0 ; i < nums.length ; i ++) {
            if (zeros >= 2) {
                nums[i] = 0;
            } else if (zeros == 1) {
                if (nums[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = product;
                }
            } else {
                nums[i] = product / nums[i];
            }
            
        }

        return nums;

        
    }
}