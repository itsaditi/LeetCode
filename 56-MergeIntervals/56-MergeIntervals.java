class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        ArrayList<int[]> mergedIntervals = new ArrayList<>();

        for (int[] interval: intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size()-1)[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.get(mergedIntervals.size()-1)[1] = Math.max(interval[1], mergedIntervals.get(mergedIntervals.size()-1)[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}