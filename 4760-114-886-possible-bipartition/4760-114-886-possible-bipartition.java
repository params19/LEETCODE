class Solution {
    public boolean possibleBipartition(int n, int[][] arr) {
        List<List<Integer>> adj=new ArrayList<>();
        // int n=arr.length;
        for(int i=0;i<=n;i++)
        {
           adj.add(new ArrayList<>());
        }
        for (int[] edge : arr)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int color[]=new int[n+1];
        Arrays.fill(color,-1); 
        for(int i=1;i<=n;i++)
        {
            if(color[i]==-1)
            {
                if(bfs(adj,i,color)==false)
                {
                    return false;
                }
            }
        } 
        return true;   
    }
    public boolean bfs(List<List<Integer>> adj, int node, int color[])
    {
        Queue<Integer> que=new LinkedList<>();
        que.add(node);
        color[node]=1;
        while(!que.isEmpty())
        {
            int u=que.poll();
            for(int it : adj.get(u))
            {
                if(color[it]==color[u])
                {
                    return false;
                }
                if(color[it]==-1)
                {
                    color[it]=1-color[u];
                    que.add(it);
                }
            }
        }
        return true;
    }
}