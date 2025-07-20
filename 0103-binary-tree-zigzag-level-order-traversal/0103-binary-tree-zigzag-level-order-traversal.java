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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        boolean reverse=false;
        while(!que.isEmpty()) 
        {
            int size=que.size();
            Deque<Integer> level=new LinkedList<>();
            for (int i=0;i<size;i++) 
            {
                TreeNode curr=que.poll();
                if(reverse) {
                    level.addFirst(curr.val);
                } else {
                    level.addLast(curr.val);
                }
                if(curr.left != null)que.add(curr.left);
                if(curr.right != null)que.add(curr.right);
            }
            ans.add(new ArrayList<>(level));
            reverse = !reverse; 
        }
        return ans;
    }
}