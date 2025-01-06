class Solution {
    private boolean isBSTHelper(TreeNode node, long lower_limit, long upper_limit) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower_limit || upper_limit <= node.val) {
            return false;
        }
        return isBSTHelper(node.left, lower_limit, node.val) && isBSTHelper(node.right, node.val, upper_limit);
    }
    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}