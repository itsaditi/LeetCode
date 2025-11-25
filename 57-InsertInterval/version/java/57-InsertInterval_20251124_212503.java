// Last updated: 11/24/2025, 9:25:03 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalList = new ArrayList<>();

        for (int[] interval: intervals) {
            intervalList.add(interval);
        }

        intervalList.add(newInterval);

        Collections.sort(intervalList, (a, b) -> a[0] - b[0]);
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
        System.out.println(resultInterval);

        return resultInterval.toArray(new int[resultInterval.size()][2]);
        
    }
}