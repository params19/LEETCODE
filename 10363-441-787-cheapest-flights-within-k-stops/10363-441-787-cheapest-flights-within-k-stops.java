class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int flight[]: flights)
        {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int res[]=new int[n];
        res=bfs(n, adj, src, k);
        if(res[dst]==Integer.MAX_VALUE)return -1;
        return res[dst];
    }
    public int[] bfs(int n, List<List<int[]>>adj, int src, int k)
    {
        int dist[]=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int []> que=new LinkedList<>();
        que.add(new int[]{src,0});
        int stops=0;
        while(!que.isEmpty()&&stops<=k)
        {
            int size=que.size();
            int[] tempDist = dist.clone();
            while(size-->0)
            {
            int curr[]=que.poll();
            int u=curr[0];
            int d=curr[1];
            if(d>dist[u])continue;
            for(int edge[]: adj.get(u))
            {
                int v=edge[0];
                int d_=edge[1]+d;
                if(d_<tempDist[v])
                {
                    tempDist[v]=d_;
                    que.add(new int[]{v, d_});
                }
            }
            }
            dist=tempDist;
            stops++;
        }
        return dist;
    }
}