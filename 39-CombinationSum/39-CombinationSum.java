class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtracking(candidates, target, result, curr, 0);
        return result;
    }

    private void backtracking(
        int[] candidates,
        int remain,
        List<List<Integer>> result,
        List<Integer> curr,
        int startIndex
    ) {
        // Base case - 
        if (remain == 0) {
            result.add(new ArrayList<>(curr));
        } else if (remain < 0) {
            return;
        }

        for (int i = startIndex ; i < candidates.length ; i++) {
            curr.add(candidates[i]);
            backtracking(
                candidates,
                remain - candidates[i],
                result,
                curr,
                i
            );
            curr.remove(curr.size() - 1);
        }
        return;
    }
}