class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) return 1;

        int longestLen = 0;
        int len = 0;
        TreeSet<Integer> distinctNums = new TreeSet<>();

        // Get rid of duplicates first
        for (int num: nums) {
            distinctNums.add(num);
        }

        Integer[] distinctArr = new Integer[distinctNums.size()];
        int j = 0;
        for (int num: distinctNums) {
            distinctArr[j] = num;
            j++;
        }

        for (int i = 0; i < distinctArr.length - 1 ; i++) {
            if (distinctArr[i + 1] - distinctArr[i] == 1) {
                len++;
            } else {
                len = 0;
            }
            longestLen = Math.max(len, longestLen);
        } 

        return longestLen + 1;
    }
}