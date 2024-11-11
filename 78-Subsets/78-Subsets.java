class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums, 0);

        return res;
    }

    private void backtrack(ArrayList<Integer> curr, List<List<Integer>> res, int[] nums, int index) {
        Collections.sort(curr);
        res.add(new ArrayList<>(curr));

        for (int i = index ; i < nums.length ; i ++) {
            curr.add(nums[i]);
            System.out.println(curr);
            backtrack(curr, res, nums, i + 1);
            curr.remove(curr.size() - 1);
        }

        return;
    }
}