class Solution {
    public void sortColors(int[] nums) {
        // Bubble Sort
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 0 ; i < nums.length - 1 ; i ++) {
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i +1);
                    swapped = true;
                }
            }

         } while (swapped);
    }

    private void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}