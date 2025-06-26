// Last updated: 6/26/2025, 12:10:13 AM
enum State {
    UNVISITED,
    VISITING,
    VISITED
}

class Solution {

    boolean cycleFound;
    Map<Integer, State> nodeMap;
    Map<Integer, List<Integer>> adjList;
    List<Integer> order;


    // TC and SC - O(V + E) where 
    //  V - number of vertices
    //  E - number of edges
    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {

        // Declare global variables
        cycleFound = false;
        nodeMap = new HashMap<>();
        adjList = new HashMap<>();
        order = new ArrayList<>();
        
        // By default all nodes are in UNVISITED STATE
        for (int i  = 0 ; i < numCourses ; i++) {
            nodeMap.put(i, State.UNVISITED);
            adjList.put(i, new ArrayList<>());
        }

        // Create Adjanecy List [a, b] where b will be mapped to list(a, c, ...)
        for (int i = 0 ; i < prerequisites.length ; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Call DFS from Unvisited Nodes
        for (int i = 0; i < numCourses ; i++) {
            if (nodeMap.get(i) == State.UNVISITED) {
                dfs(i);
            }
        }

        // If cycle was found, return an empty array
        if (cycleFound) {
            return new int[0];
        }

        int[] orderArray = new int[numCourses];

        for (int i = 0; i < numCourses ; i++) {
            orderArray[i] = order.get(numCourses - i - 1);
        }

        return orderArray;

    }

    private void dfs (int node) {
        // If cycle is found, return
        if (cycleFound) {
            return;
        }

        // Start visiting the node
        nodeMap.put(node, State.VISITING);

        // Traverse node's neighbours
        for (int neighbor : adjList.get(node)) {
            if (nodeMap.get(neighbor) == State.VISITING) {
                cycleFound = true;
            } else if (nodeMap.get(neighbor) == State.UNVISITED) {
                dfs(neighbor);
            }
        }

        // Recursion ends. Mark node as VISITED
        nodeMap.put(node, State.VISITED);

        // Add such visited node to the order list
        order.add(node);
    }


    // TC and SC - O(V + E) where 
    //  V - number of vertices
    //  E - number of edges

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>();

        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        // Add all nodes to adjList with empty list
        for (int i  = 0 ; i < numCourses ; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Create Adjanecy List [a, b] where b will be mapped to list(a, c, ...)
        for (int i = 0 ; i < prerequisites.length ; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            adjList.get(src).add(dest);

            inDegree[dest] += 1;
        }

        // Add all nodes with inDegree of 0 to the queue
        for (int i = 0 ; i < numCourses ; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int neighbor: adjList.get(node)) {
                // Reduce the inDegree of neighbor by 1
                inDegree[neighbor]--;

                // If inDegree of neighbour is 0, then add to queue
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }

        }

        if (order.size() == numCourses) {
            int[] result = order.stream().mapToInt(i -> i).toArray();
            return result;
        }

        return new int[0];
    }
}