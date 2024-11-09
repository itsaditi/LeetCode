class Solution {
    HashSet<List<Integer>> sumCombo = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        checkCombo(candidates, target, new int[0]);
        return new ArrayList<>(sumCombo);
    }

    private void checkCombo(int[] candidates, int target, int[] candy) {
        if (target == 0) { 
            Arrays.sort(candy);
            List<Integer> arr = new ArrayList<>();
            for (int can: candy) arr.add(can);
            System.out.println(arr);
            sumCombo.add(arr);
            return;
        }

        if (target < 0) return;

        for (int cand: candidates) {
            int[] newArr = Arrays.copyOf(candy, candy.length + 1);
            newArr[newArr.length - 1] = cand;
            checkCombo(candidates, target - cand, newArr);
        }

        return;
    }
}