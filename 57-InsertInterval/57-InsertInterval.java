class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // STEP 1 - Insert new Interval, add it to intervals and sort it;
        List<int[]> intervalWithNewInterval = new ArrayList<>();

        for (int[] interval: intervals) intervalWithNewInterval.add(interval);

        intervalWithNewInterval.add(new int[]{newInterval[0], newInterval[1]});
        intervalWithNewInterval.sort((a,b) -> a[0]-b[0]);

        // STEP 2 - Merge overlapping Intervals
        List<int[]> mergedIntervals = new LinkedList<>();
        for (int[] interval: intervalWithNewInterval) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);


    }
}