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
    int i=0;
    public TreeNode recoverFromPreorder(String st) {
        int n=st.length();
        return solve(st, 0);
  }
  public TreeNode solve(String st, int depth)
  {
    int n=st.length();
    if(i>=n)return null;
    int j=i;
    while(j<n&&st.charAt(j)=='-')
    {
        j++;
    }
    int dash=j-i;
    if(depth!=dash)return null;
    int num=0;
    i=j;
    while(i<n&&Character.isDigit(st.charAt(i))==true)
    {
        num=(num*10)+(st.charAt(i)-'0');
        i++;
    }
    TreeNode root=new TreeNode(num);
    root.left=solve(st, depth+1);
    root.right=solve(st, depth+1);
    return root;
  }
}