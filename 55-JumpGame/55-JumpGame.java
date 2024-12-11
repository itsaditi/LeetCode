public boolean canJump(int[] nums) {
    if (nums.length == 0)
        throw new IllegalArgumentException("nums can't be empty");
    int farthest = 0;
    for (int i = 0; i <= farthest && i < nums.length; ++i) {
        farthest = Math.max(farthest, i + nums[i]);
    }
    return farthest >= nums.length - 1;
}