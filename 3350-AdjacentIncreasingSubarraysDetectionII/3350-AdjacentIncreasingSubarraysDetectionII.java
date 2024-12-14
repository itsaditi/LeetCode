class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        List<int[]> subArrayIndex = new ArrayList<>();
        int[] arr = new int[2];
        int i = 0, j = i + 1;

        while (i < nums.size() && j < nums.size()) {
            if (nums.get(j - 1) >= nums.get(j)) {
                if (nums.get(i) != nums.get(j - 1) || i != j - 1) {
                    subArrayIndex.add(new int[]{i, j - 1});
                }
                i = j;
            }
            if (j == nums.size() - 1) {
                if (nums.get(i) != nums.get(j) || i != j) subArrayIndex.add(new int[]{i, j});
                break;
            }
            
            j++;
        }

        if (subArrayIndex.size() == 0) return 1;

        if (subArrayIndex.size() == 1) {
            return (subArrayIndex.get(0)[1] - subArrayIndex.get(0)[0] + 1) / 2;
        }

        Collections.sort(subArrayIndex,(a,b) -> a[0]-b[0]);
        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;

        for (int[] subArray: subArrayIndex) {
            maxSize = Math.max(
                (subArray[1] - subArray[0] + 1) / 2,
                maxSize
            );
        }

        for (int k = 0; k < subArrayIndex.size() - 1; k++) {
            if (subArrayIndex.get(k)[1] == subArrayIndex.get(k + 1)[0] - 1) {
                minSize = Math.min(
                    (subArrayIndex.get(k)[1] - subArrayIndex.get(k)[0] + 1),
                    (subArrayIndex.get(k + 1)[1] - subArrayIndex.get(k + 1)[0] + 1)
                );
                maxSize = Math.max(minSize, maxSize);
            } 
        }



        return maxSize;
    }
}