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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair<TreeNode, Integer>> que=new LinkedList<>();
        que.add(new Pair<>(root, 0));
        int ans=0;
        while(!que.isEmpty())
        {
            int n=que.size();
            int min=que.peek().getValue();
            int first=0, last = 0;
            for(int i=0;i<n;i++)
            {
                Pair<TreeNode, Integer> p=que.poll();
                TreeNode node = p.getKey();
                int idx=p.getValue()-min; 
                if(i==0)first=idx;
                if(i==n-1)last=idx;
                if(node.left!=null)
                    que.offer(new Pair<>(node.left, 2*idx));
                if(node.right!=null)
                    que.offer(new Pair<>(node.right, 2*idx+1));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}