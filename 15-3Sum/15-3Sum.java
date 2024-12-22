class Solution {

    //  public List<List<Integer>> threeSum(int[] nums) {
    //     HashMap<Integer

    //  }

























    public List<List<Integer>> threeSum(int[] nums) {
        // Time Complexity - O(nlogn) (Sort) + O(n^2) ~ O(nlogn + n^2)
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length ; i ++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                // No need to call twoSum for duplicate 
                // elements after calling it once
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i , List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<>();

        for (int j = i + 1; j < nums.length ; j++) {
            int complement = - (nums[i] + nums[j]);

            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                
                // Increment j until you find unique elements
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            seen.add(nums[j]);
        }
    }
}