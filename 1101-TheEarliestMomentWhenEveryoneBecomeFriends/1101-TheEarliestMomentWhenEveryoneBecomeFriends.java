class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public int earliestAcq(int[][] logs, int n) {
        // Total TC - O(n^2 + log n)
        // Total SC - O(n)

        // O(log n)
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);

        // O(n)
        for (int[] log: logs) {
            int friend1 = log[1];
            int friend2 = log[2];

            if (!graph.containsKey(friend1)) {
                graph.put(friend1, new ArrayList<>());
            }

            if (!graph.containsKey(friend2)) {
                graph.put(friend2, new ArrayList<>());
            }

            graph.get(friend1).add(friend2);
            graph.get(friend2).add(friend1);

            if (areAllAcq(n)) return log[0];
        }   
        return -1;
    }

    private boolean areAllAcq(int n) {
        // BFS TC - O(n)
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        System.out.println(graph);
        queue.add(0);

        while(!queue.isEmpty()) {
            int poppedElement = queue.poll();

            visited.add(poppedElement);
            if (graph.containsKey(poppedElement)) {
                for (int friend: graph.get(poppedElement)) {
                    if (!visited.contains(friend)) queue.add(friend);
                }
            }
        }

        if (visited.size() == n) return true;

        return false;
    }
}