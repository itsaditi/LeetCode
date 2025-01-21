class Solution {

    // TC and SC - O(N)
    public boolean validTree(int n, int[][] edges) {
        // Graph Theory

        // If number of edges are less than n - 1 -> not all edges are connected to form team
        // If number of edges are more than n - 2 -> Graph contains cycle
        if (edges.length != n - 1) {
            return false;
        }

        if (n == 1 && edges.length == 0) {
            return true;
        }

        // Create map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int root = Integer.MAX_VALUE;

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }

            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }

            map.get(a).add(b);
            map.get(b).add(a);
            root = Math.min(a, root);
            root = Math.min(b, root);
        }

        // BFS -
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            int poppedElem = queue.poll();


            for (int neigbour: map.get(poppedElem)) {
                queue.add(neigbour);
                visited.add(neigbour);
                map.get(neigbour).remove(Integer.valueOf(poppedElem));
            }
        }


        return visited.size() == n;


    }
}