class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;


        for (int i = 0 ; i < nums.length ; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i -1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i + 1] && nums[i] > nums[i -1]) return i;
            }
        }

        return 0;

    }
    public int findPeakElement_(int[] nums) {
        if (nums.length == 1) return 0;

        if (nums.length == 2) return returnPeakIndex(0, 1, nums);
        ArrayList<Integer> peakIndex = new ArrayList<>();
        int windowSize =  3;
        
        for (int i = 0 ; i < nums.length - windowSize + 1 ; i++) {
            if (i == 0 || i > 0 && nums[i] > nums[i-1]) {
                peakIndex.add(returnPeakIndex(i, windowSize - 1 + i, nums));
            }
        }
        return peakIndex.size() > 0 ? peakIndex.get(peakIndex.size()-1) : 0;
    }

    private int returnPeakIndex(int startIndex, int endIndex, int[] nums) {
        int peakElem = Math.max(nums[startIndex], nums[startIndex + 1]);
        peakElem = Math.max(nums[endIndex], peakElem);

        return findIndex(startIndex, endIndex, peakElem, nums);
    }

    private int findIndex(int startIndex, int endIndex, int target, int[] nums) {
        for(int i = startIndex ; i <= endIndex ; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}