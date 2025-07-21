/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int idx; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=postorder.length-1;
        return solve(inorder, postorder, 0, postorder.length-1);
    }
    public TreeNode solve(int[] inorder, int[] postorder, int start, int end) 
    {
        if(start>end)return null;
        int rootVal=postorder[idx];
        int i=start;
        while(i<=end&&inorder[i]!=rootVal) {
            i++;
        }
        idx--;
        TreeNode root = new TreeNode(rootVal);
        root.right = solve(inorder, postorder, i + 1, end);
        root.left = solve(inorder, postorder, start, i - 1);
       
        return root;
    }
}