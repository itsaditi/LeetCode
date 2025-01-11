class Solution {

    public int longestConsecutive(int[] nums) {
        // Edge cases - 
        if (nums.length == 0) return 0;

        if (nums.length == 1) return 1;

        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int longestlcq = 0;

        for (int num: set) {

            // Skip checking for longest sequence starting from num,
            // if its previous number exists in the set.
            // As such number would already be a part of a longer sequence.
            if (!set.contains(num - 1)){
                int currNum = num;
                int lcq = 1;

                while (set.contains(currNum + 1)) {
                    currNum ++;
                    lcq++;
                }

                longestlcq = Math.max(lcq, longestlcq);
            }

            
        }

        return longestlcq;

    }


    public int longestConsecutive_TLE(int[] nums) {
        // Edge cases - 
        if (nums.length == 0) return 0;

        if (nums.length == 1) return 1;

        // Put all elements in Set to get rid of duplicates.
        // Do Bubble Sort on it.
        // Check for longest consecutive sequence

        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        Integer[] distinctNums = set.toArray(new Integer[set.size()]);

        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 0 ; i < distinctNums.length - 1 ; i++) {
                if (distinctNums[i] > distinctNums[i+1]) {
                    swap(distinctNums, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);

        // [1,2,3,4]


        int lcqLen = 0;
        int longestlcqLen = 0;

        for (int i = 1 ; i < distinctNums.length ; i++) {
            if (distinctNums[i] - distinctNums[i - 1] == 1) {
                lcqLen++;
            } else {
                lcqLen = 0;
            }
            longestlcqLen = Math.max(lcqLen, longestlcqLen);
        }

        return longestlcqLen + 1;

    }

    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }




    public int longestConsecutive_UsingTreeSet(int[] nums) {
        /* NOT TO FORGET -
         * 1. Two edge cases
         * 2. To remove duplicates
         */

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