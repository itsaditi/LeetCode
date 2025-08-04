// Last updated: 8/4/2025, 4:50:11 PM
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int len = pattern.length + 1;
        int ans = 0;

        for (int i = 0 ; i <= nums.length - len ; i++) {
            boolean flag = true;

            for (int j = i , k = 0 ; j < i + len - 1 ; j++, k++) {
                if (pattern[k] == 1 && (nums[j] >= nums[j + 1])) {
                    flag = false;
                } else if (pattern[k] == -1 && (nums[j] <= nums[j+1])) {
                    flag = false;
                } else if (pattern[k] == 0 && (nums[j] != nums[j+1])) {
                    flag = false;
                }
            }

            if (flag) ans++;
        }

        return ans;
    }
}