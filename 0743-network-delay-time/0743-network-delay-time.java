class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[] : times)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int dist[]=new int[n+1];
        dist=dijkstra(n, adj, k);
        int mx=0;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)return -1;
            mx=Math.max(dist[i],mx);
        }
        return mx;
    }
    public int[] dijkstra(int n, List<List<int []>> adj, int src)
    {
        int dist[]=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparing(a->a[1]));
        pq.add(new int[]{src,0});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int u=curr[0];
            int d=curr[1];
            if(d>dist[u])continue;
            for(int edge[]: adj.get(u))
            {
                int v=edge[0];
                int d_=edge[1]+d;
                if(d_<dist[v])
                {
                    dist[v]=d_;
                    pq.add(new int[]{v,d_});
                }
            }
        }
        return dist;
    }

}