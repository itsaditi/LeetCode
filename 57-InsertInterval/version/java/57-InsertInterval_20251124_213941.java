// Last updated: 11/24/2025, 9:39:41 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalList = new ArrayList<>();
        boolean newIntervalInserted = false;

        for (int[] interval: intervals) {
            if (newInterval[0] < interval[0]) {
                intervalList.add(newInterval);
                newIntervalInserted = true;
            }
            intervalList.add(interval);
        }

        if (!newIntervalInserted) intervalList.add(newInterval);
       

        List<int[]> resultInterval = new ArrayList<>();

        // [[1,3],[2,5],[6,9]]
        for (int[] interval: intervalList) {
            if (resultInterval.isEmpty() || resultInterval.getLast()[1] < interval[0]) {
                resultInterval.add(interval); // [[1,5], [6,9]]
            } else {
                // [[1,3]]
                resultInterval.getLast()[1] = Math.max(resultInterval.getLast()[1], interval[1]);
            }
        }

        return resultInterval.toArray(new int[resultInterval.size()][2]);
        
    }
}