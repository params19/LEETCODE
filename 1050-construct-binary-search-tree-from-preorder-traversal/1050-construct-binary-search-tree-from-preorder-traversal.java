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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int inorder[]=new int[n];
        for(int i=0;i<n;i++)
        {
            inorder[i]=preorder[i];
        }
        idx=0;
        return solve(preorder, inorder, 0, preorder.length - 1);
    }
      public TreeNode solve(int[] preorder, int[] inorder, int start, int end) 
       {
        Arrays.sort(inorder);
        if(start>end)return null;
        int rootVal=preorder[idx];
        int i=start;
        while(i<=end&&inorder[i]!=rootVal) {
            i++;
        }
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);
        return root;
    }
}