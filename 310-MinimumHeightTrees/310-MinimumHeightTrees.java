class Solution {
  // TC - O(n^2) SC - O(n)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            List<Integer> arr = new ArrayList<>();
            arr.add(0);
            return arr;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        TreeMap<Integer, List<Integer>> minHeightMap = new TreeMap<>();
        int minDepth = Integer.MAX_VALUE;

        // O(n)
        for (int i = 0 ; i < edges.length ; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            // Create link between a and b
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }

            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int i = 0 ; i < n ; i++) {
            int depth = bfs(i , graph);
            minDepth = Math.min(minDepth, depth);
            if (!minHeightMap.containsKey(depth)) {
                minHeightMap.put(depth, new ArrayList<>());
            }

            minHeightMap.get(depth).add(i);
        }
        return minHeightMap.get(minDepth);
    }

    private int bfs(int root, HashMap<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int depth = 0;

        stack.add(new Pair(root, 1));
        visited.add(root);

        while (!stack.isEmpty()) {
            Pair poppedElement = stack.pop();
            int node = (int) poppedElement.getKey();
            int distance = (int) poppedElement.getValue();

            for(int children: graph.get(node)) {
                if (!visited.contains(children)) {
                    stack.add(new Pair(children, distance + 1));
                    visited.add(children);
                }
            }
            depth = Math.max(depth, distance);
        }

        return depth;
    }
}
