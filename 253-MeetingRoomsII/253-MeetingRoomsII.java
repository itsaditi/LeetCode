class Solution {

    public int minMeetingRooms(int[][] intervals) {
        // Edge Cases
        if(intervals == null) return 0;
        if(intervals. length == 0) return 0;
        if(intervals.length <= 1) return 1;

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        // Sort array by start time 
        Arrays.sort(intervals, (a, b) -> a[0]- b[0]);

        // Add end time of the first interval after sorting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If an old room is allocated, add to the heap
            allocator.add(intervals[i][1]);
        }

        return allocator.size();

    }
    public int minMeetingRooms_1(int[][] intervals) {
        
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