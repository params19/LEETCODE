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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null){
        solve(root, "");
        }
        return ans;
    }
    public void solve(TreeNode root, String st)
    {
        if(root==null)return;
        st+=root.val;
        if(root.left==null&&root.right==null)
        {
            ans.add(st);
            return;
        }
        if(!st.isEmpty()){
            st+="->";
        }
       
        solve(root.left, st);
        solve(root.right, st);
    }
}