// Last updated: 8/4/2025, 4:50:06 PM
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        // Time Complexity - O(n) + O(log n) + O(k) ~ O(n + log n + k)
        // Space Complexity - O(n)


        List<int[]> subArrayIndex = new ArrayList<>();
        int i = 0, j = i + 1;

        // Created a list of [startIndex, endIndex] of increasing subArrays - O(n)
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

        // If there is no element in subArrayIndex, 
        // means that there is no increasing subArray
        if (subArrayIndex.size() == 0) return 1;

        // If there is only 1 increasing subarray,
        // return size / 2 of that subArray
        if (subArrayIndex.size() == 1) {
            return (subArrayIndex.get(0)[1] - subArrayIndex.get(0)[0] + 1) / 2;
        }

        // O(log n)
        Collections.sort(subArrayIndex,(a,b) -> a[0]-b[0]);

        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;

        for (int[] subArray: subArrayIndex) {
            maxSize = Math.max(
                (subArray[1] - subArray[0] + 1) / 2,
                maxSize
            );
        }

        // O(k) where k is the length of subArrayIndex
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