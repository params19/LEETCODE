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
    public HashMap<TreeNode, Integer> mp=new HashMap<>();
    public int mx=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root, 0);
        TreeNode ans=lca(root);
        return ans;
    }
    public void depth(TreeNode root, int d)
    {
        if(root==null)return;
        mx=Math.max(mx,d);
        mp.put(root, d);
        depth(root.left, d+1);
        depth(root.right, d+1);
    }
    public TreeNode lca(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        if(mp.get(root)==mx)return root;
        TreeNode left=lca(root.left);
        TreeNode right=lca(root.right);
        if(left!=null&&right!=null)
        {
            return root;
        }
        return left!=null?left:right;
    }
}