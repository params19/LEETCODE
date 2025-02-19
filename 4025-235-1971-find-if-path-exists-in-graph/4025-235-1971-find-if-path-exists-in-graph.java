class Solution {
    public boolean validPath(int n, int[][] edges, int so, int dest) {
        boolean vis[]=new boolean[n];
        Queue<Integer> que=new LinkedList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) 
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        que.add(so);
        vis[so]=true;
        while(!que.isEmpty())
        {
            int val=que.poll();
            for(int it: adj.get(val))
            {
                if(vis[it]==false)
                {
                    vis[it]=true;
                    que.add(it);
                }
            }
        }
        if(vis[dest]==false)return false;
        return true;
    }
}