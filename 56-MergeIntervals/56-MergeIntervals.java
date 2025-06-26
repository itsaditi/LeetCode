// Last updated: 6/26/2025, 12:35:50 AM
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        ArrayList<int[]> mergedIntervals = new ArrayList<>();

        for (int[] interval: intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.getLast()[1] = Math.max(interval[1], mergedIntervals.getLast()[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
} 