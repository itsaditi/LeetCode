class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;

        int numOfTriplets = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            numOfTriplets += twoSum(nums, i, target);
        }

        return numOfTriplets;
    }

    private int twoSum(
        int[] nums,
        int i,
        int target
    ) {
        int left = i + 1;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = target - nums[left] - nums[right];

            if (nums[i] < sum) {
                // IMPORTANT
                // TRICKY PART HERE
                // IF THREESUM < TARGET, THEN BECAUSE THEE ARRAY IS SORTED
                // ALL NUMBERS IN BETWEEN WILL ALSO BE LESS OR EQUAL TO K
                // AND THEREFORE BE VALID ANSWERS
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}