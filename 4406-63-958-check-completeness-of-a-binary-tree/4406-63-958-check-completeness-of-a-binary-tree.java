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
    public boolean isCompleteTree(TreeNode root) {
       Queue<TreeNode> que=new LinkedList<>();
       que.add(root);
       boolean flag=false;
       while(!que.isEmpty())
       {
        TreeNode node=que.poll();
        if(node==null)
        {
            flag=true;
        }
        else{
            if(flag)return false;
            que.add(node.left);
            que.add(node.right);
        }
       }
       return true;
    }
    // public boolean check(TreeNode left, TreeNode right)
    // {
    //     if(left==null&&right==null)
    //     {
    //         return true;
    //     }
    //     else if((left.left==null&&right.right!=null)&&(check(left.left, right.right)))
    //     {
    //         return false;
    //     }
    // }
}