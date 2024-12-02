class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals == null) return 0;
        if(intervals. length == 0) return 0;
        if(intervals.length <= 1) return 1;

        // create the start time array
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        // create the end time array
        for(int i = 0 ; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int room = 0;
        int endTime = 0;
        for(int i = 0; i < starts.length; i++){
            if(starts[i] < ends[endTime]){
                room++;
            } else {
                endTime++;
            }
        }
        return room;
    }
}