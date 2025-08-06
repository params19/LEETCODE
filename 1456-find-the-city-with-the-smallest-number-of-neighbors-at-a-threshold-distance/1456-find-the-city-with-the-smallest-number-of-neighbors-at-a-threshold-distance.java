class Solution {
    public int findTheCity(int n, int[][] edges, int x) {
        List<List<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges)
        {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        int ans=-1;
        int minReachable=n;
        for(int i = 0; i < n; i++) 
        {
            int[] dist=dijkstra(i, adj, n);
            int count=0;
            for(int j = 0; j <n; j++) {
                if(i != j && dist[j]<=x) {
                    count++;
                }
            }
            if (count<=minReachable) {
                minReachable=count;
                ans=i;
            }
        }
        return ans;
    }
    public int[] dijkstra(int src, List<List<int []>> adj, int n)
    {
        int dest[]=new int[n];
        Arrays.fill(dest, Integer.MAX_VALUE);
        dest[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, src});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int d=curr[0];
            int u=curr[1];
            if(dest[u]<d)continue;
            for(int edge[]: adj.get(u))
            {
                int v=edge[0];
                int d_=edge[1]+d;
                if(d_<dest[v])
                {
                    dest[v]=d_;
                    pq.add(new int[]{d_, v});
                }
            }
        }
        return dest;
    }
}