class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        que.add(root);
        while(!que.isEmpty())
        {
            int size=que.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                if(que.peek().left!=null)que.add(que.peek().left);
                if(que.peek().right!=null)que.add(que.peek().right);
                ll.add(que.poll().val);
            }
            ans.add(ll);
        }
        return ans;
    }
}