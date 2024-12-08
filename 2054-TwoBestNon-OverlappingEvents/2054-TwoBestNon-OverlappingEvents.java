class Solution {
    public int maxTwoEvents(int[][] events) {
        int maxSum = 0, maxVal = 0;;

        // Store EndTime and Value
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey)
        );

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // As we process each event, we remove all valid events from the priority queue 
        // that end before the current event starts, as they are guaranteed not to overlap. 
        // While removing these events, we update maxVal to store the highest value of 
        // these popped events. For the current event, we calculate the maximum possible 
        // sum by adding its value to maxVal, representing the best event that ended before 
        // the current event started, and update the maxSum if this sum is greater. 
        // The current event is then added to the priority queue to be considered for future combinations.

        for (int[] event: events) {
            
            // Pop non-overlapping events
            while(!pq.isEmpty() && pq.peek().getKey() < event[0]) {
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + event[2]);
            pq.add(new Pair<Integer, Integer>(event[1], event[2]));
        }

        return maxSum;
    }
}