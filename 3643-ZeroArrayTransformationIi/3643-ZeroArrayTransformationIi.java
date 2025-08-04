// Last updated: 8/4/2025, 4:50:08 PM
class Solution {
    int n = 0;
    public int minZeroArray(int[] nums, int[][] queries) {
        // I have no idea why this works, find it out.
        // Source - https://www.youtube.com/watch?v=poysE6Ze_-s
        n = nums.length;
        int q = queries.length;

        int left = 0;
        int right = q + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (good(mid, nums, queries)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == q + 1) return -1;

        return left;
    }

    private boolean good(int target, int[] nums, int[][] queries) {
        int[] diffArray = new int[n + 1];

        for (int i = 0; i < target; i++) {
            diffArray[queries[i][0]] += queries[i][2];
            diffArray[queries[i][1] + 1] -= queries[i][2];
        }

        for (int j = 1; j < n + 1; j++) {
            diffArray[j] += diffArray[j - 1];
        }

        for (int k = 0; k < n; k++) {
            if (nums[k] > diffArray[k]) return false;
        }
        return true;
    }
}