# Last updated: 8/4/2025, 4:50:36 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maximumAverageSubtree(self, root: TreeNode) -> float:
        
        # DFS recursively - Postorder
        
        def dfs(node: TreeNode):
            if node is None:
                return (0,0)
            
            # Get the sum of left subtree and count of node in left subtree
            sum_left, left_node_count = dfs(node.left)
            
            sum_right, right_node_count = dfs(node.right)
            
            # Number of nodes in the tree
            node_count = 1 + left_node_count + right_node_count
            
            # Computing the average
            
            computed_avg = (sum_left + sum_right +node.val)/ node_count
            
            if computed_avg > self.maxavg:
                self.maxavg = computed_avg
            
            return ((sum_left + sum_right +node.val), node_count)
            
        
        self.maxavg = float("-inf")
        dfs(root)
        
        return self.maxavg
            
            
            
            