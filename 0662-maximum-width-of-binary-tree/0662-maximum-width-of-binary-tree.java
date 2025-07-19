class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null)return 0;
        Queue<Pair<TreeNode, Long>> que=new LinkedList<>();
        que.offer(new Pair<>(root, 0L));
        long maxWidth= 0;
        while (!que.isEmpty()) 
        {
            int n=que.size();
            long first= que.peek().getValue();
            long last=0;
            for (int i=0;i<n;i++) 
            {
                Pair<TreeNode, Long> p = que.poll();
                TreeNode node = p.getKey();
                long idx = p.getValue() - first;//yahi normalise kar rhe h
                if(i==n-1)last=idx;
                if(node.left!=null)
                    que.offer(new Pair<>(node.left, 2*idx+1));
                if(node.right!=null)
                    que.offer(new Pair<>(node.right, 2*idx+2));
            }
            maxWidth=Math.max(maxWidth, last+1);
        }
        return (int)maxWidth;
    }
}
