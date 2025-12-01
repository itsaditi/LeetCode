// Last updated: 12/1/2025, 5:14:43 PM
1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        int n = nums.length;
4        List<Integer> missingNums = new ArrayList<>();
5        boolean[] seen = new boolean[nums.length];
6
7        for (int i = 0 ; i < n ; i++) {
8            seen[nums[i] - 1] = true;
9        }
10
11        for (int i = 0 ; i < n ; i++) {
12            if (!seen[i]) {
13                missingNums.add(i + 1);
14            }
15            System.out.println(" "  + (i + 1) + " - " + seen[i] );
16        }
17        return missingNums;
18    }
19}