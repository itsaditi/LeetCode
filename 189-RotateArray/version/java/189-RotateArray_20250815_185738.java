// Last updated: 8/15/2025, 6:57:38 PM
class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];

        for (int i = 0 ; i < nums.length; i ++) {
            int newIndex = (i + k) % nums.length;
            res[newIndex] = nums[i];
        }

        for (int i = 0 ; i < nums.length; i ++) {
            nums[i] = res[i];
        }
    }
}

