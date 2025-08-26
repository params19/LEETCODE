class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], 2*edge[2]});
        }
        int res[]=new int[n];
        res=dijkstra(n, adj, 0);
        if(res[n-1]==Integer.MAX_VALUE)return -1;
        return res[n-1];
    }
    public int[] dijkstra(int n, List<List<int[]>> adj, int src)
    {
        int dis[]=new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{src,0});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int u=curr[0];
            int d=curr[1];
            if(d>dis[u])continue;
            for(int edge[] : adj.get(u))
            {
                int v=edge[0];
                int d_=edge[1]+d;
                if(d_<dis[v])
                {
                    dis[v]=d_;
                    pq.add(new int[]{v, d_});
                }
            }
        }
        return dis;
    }
}