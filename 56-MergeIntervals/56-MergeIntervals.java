class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by 1st element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);

        // int[][] merged = new int[intervals.length][2];
        // int start = 0;

        // for(int[] interval: intervals){

        //     if(start == 0 || merged[start - 1][1] < interval[0]){
        //         merged[start] = interval;
        //         start++;
        //     } else {
        //         merged[start-1][1] = Math.max(merged[start-1][1], interval[1]);
        //     }
        // }

        // return Arrays.copyOf(merged, start);
        // return merged;

    
    }
}