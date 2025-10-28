// Last updated: 10/27/2025, 9:32:49 PM
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }

            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }

            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (vertex == destination) {
                return true;
            }

            for (int connectedVertex: map.get(vertex)) {
                if (!visited[connectedVertex]) {
                    queue.add(connectedVertex);
                    visited[connectedVertex] = true;
                } 
            }
        }

        return false;
    }
}

/*
{
    0 = [1, 2],
    1 = [0, 2]
    2 = [1, 0]
}

Queue -  2, 2
Visited Set - 0, 1, 2



*/