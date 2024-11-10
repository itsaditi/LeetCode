class Solution {
    int numsLen = 0;
    public List<List<Integer>> permute(int[] nums) {
        numsLen = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums);
        return res;
    }

    private void backtrack(
        List<Integer> curr, 
        List<List<Integer>> ans, 
        int[] nums
    ) {
        if (curr.size() == numsLen) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}