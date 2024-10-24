class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipCheck(root1, root2);
    }

    private boolean flipCheck(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        
        if (node1 == null || node2 == null)
            return false;

        if (node1.val != node2.val) return false;

        boolean leftMatched = flipCheck(node1.left, node2.left) || flipCheck(node1.left, node2.right);
        boolean rightMatched = flipCheck(node1.right, node2.left) || flipCheck(node1.right, node2.right);

        return leftMatched && rightMatched;
    }
}