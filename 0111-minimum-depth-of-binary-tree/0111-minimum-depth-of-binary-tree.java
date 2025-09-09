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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int cnt=0;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            int n=que.size();
            for(int i=0;i<n;i++)
            {
            TreeNode curr=que.poll();
            if(curr.left==null&&curr.right==null)return cnt+1;
            if(curr.left!=null)que.add(curr.left);
            if(curr.right!=null)que.add(curr.right);
            }
            cnt++;
        }
        return cnt+1;
    }
}