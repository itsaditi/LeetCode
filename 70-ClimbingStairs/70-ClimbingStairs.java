class Solution {
    HashMap<Integer, Integer> cacheResult = new HashMap<>();

    public int climbStairs(int n) {
        /** Recursion Stack */
        return climbingStairs(0, n);
    }

    private Integer climbingStairs (int i, int n) {
        // Edge case
        if (i > n) return 0;

        if (i == n) return 1;

        if (cacheResult.containsKey(i)) return cacheResult.get(i);

        Integer res = climbingStairs(i + 1, n) + climbingStairs(i + 2, n);
        cacheResult.put(i, res);

        return res;
    }
}