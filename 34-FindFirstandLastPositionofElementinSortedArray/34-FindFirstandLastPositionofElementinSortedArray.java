class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        for (int i = 0; i < nums.length ; i++) {
            if (res[0] == -1) {
                if (nums[i] == target) {
                    res[0] = i;
                    res[1] = i;
                }
            } else {
                if (nums[i] == target) {
                    res[1] = i;
                }
            }
        }

        return res;
    }
}