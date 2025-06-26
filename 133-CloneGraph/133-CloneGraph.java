// Last updated: 6/26/2025, 12:54:10 AM
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visitedNode = new HashMap<>();

    public Node cloneGraph(Node node) {
        // DFS
        // Time Complexity --> O(N + M) , where N is number of nodes and M is number of edges
        // Space Complexity --> O(N), for Hashmap and O(H) occupied by recursion stack where H is
        //      the height of the graph 
         if (node == null) return node;

        if (visitedNode.containsKey(node)) {
            return visitedNode.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());

        visitedNode.put(node, clonedNode);

        for (Node neighbour: node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbour));
        }

        return clonedNode;
        
    }


    public Node cloneGraph_BFS(Node node) {
        // ITERATIVE | bfs
        if (node == null) return node;
        HashMap<Node, Node> visitedNode = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        visitedNode.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node poppedNode = queue.remove();

            for (Node neighbour: poppedNode.neighbors) {
                if(!visitedNode.containsKey(neighbour)) {
                    visitedNode.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                    queue.add(neighbour);
                }

                visitedNode.get(poppedNode).neighbors.add(visitedNode.get(neighbour));
            }
        }
        return visitedNode.get(node);
    }

}