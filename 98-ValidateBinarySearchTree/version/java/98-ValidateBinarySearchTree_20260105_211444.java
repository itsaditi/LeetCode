// Last updated: 1/5/2026, 9:14:44 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isValidBST_bfs(TreeNode root) {
18        // BFS will not work because I need to check with main root node
19        Queue<TreeNode> queue = new LinkedList<>();
20
21        queue.add(root);
22
23        while (!queue.isEmpty()) {
24            TreeNode poppedElem = queue.poll();
25
26            if (poppedElem.left != null) {
27                if (poppedElem.left.val >= poppedElem.val)
28                    return false;
29                
30                queue.add(poppedElem.left);
31            }
32
33            if (poppedElem.right != null) {
34                if (poppedElem.right.val <= poppedElem.val)
35                    return false;
36
37                queue.add(poppedElem.right);
38            }
39
40        }
41
42        return true;
43    }
44
45    ArrayList<Integer> visitedNodes = new ArrayList<>();
46    Integer prev;
47
48    public boolean isValidBST(TreeNode root) {
49        prev = null;
50        return dfs(root);
51        // System.out.println(visitedNodes + " " + decreasingPattern);
52
53        // return decreasingPattern == 0;
54    }
55
56    private boolean dfs(TreeNode root) {
57        // inorder -> left, root, right
58
59        // Null root is valid BST
60        if (root == null) return true;
61
62        if (!dfs(root.left)) return false;
63
64        if (prev != null && prev >= root.val) return false;
65
66        prev = root.val;
67        return dfs(root.right);
68    }
69}