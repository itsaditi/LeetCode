// Last updated: 8/4/2025, 4:50:55 PM
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    ArrayList <Node> inOrderTraversal = new ArrayList<>();
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node head = new Node(0);
        dfs(root);
        Node firstNode = inOrderTraversal.get(0);

        Node lastNode = inOrderTraversal.get(inOrderTraversal.size()-1);
        
        if (inOrderTraversal.size() == 1) {
            head.right = firstNode;
            firstNode.right = lastNode;
            firstNode.left = lastNode;
            
            lastNode.right = firstNode;
            lastNode.left = firstNode;
            
        }

        for(int i = 0; i < inOrderTraversal.size()-1 ; i ++) {

            Node currNode = inOrderTraversal.get(i);
            if (i == 0 ) {
                head.right = currNode;
            }
            Node nextNode = inOrderTraversal.get(i+1);
            currNode.right = nextNode;
            nextNode.left = currNode;       
        }
        
        firstNode.left = lastNode;
        lastNode.right = firstNode;
        
        return head.right; 
    }
    
    private void dfs (Node root) {
        if (root == null) return;
        

        dfs(root.left);
        inOrderTraversal.add(root);

        dfs(root.right);
        
    }
}