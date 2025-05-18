import java.util.*;
class Solution {
    public long minimumWeight(int n, int[][] edges, int s1, int s2, int dest) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        List<List<int[]>> revadj = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            adj.add(new ArrayList<>());
            revadj.add(new ArrayList<>());
        }
        for (int[] edge : edges) 
        {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            revadj.get(v).add(new int[]{u, w}); 
        }
        long[] src1= dijkstra(n, adj, s1);
        long[] src2= dijkstra(n, adj, s2);
        long[] toDest= dijkstra(n, revadj, dest);
        long res = Long.MAX_VALUE;
        long inf= Long.MAX_VALUE;
        for(int i = 0; i < n; i++) 
        {
            if(src1[i]==inf||src2[i]==inf||toDest[i]==inf)continue;
            res=Math.min(res,src1[i]+src2[i]+toDest[i]);
        }
        return res==inf?-1:res;
    }
    public long[] dijkstra(int n, List<List<int[]>> adj, int src) 
    {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{src, 0});
        while (!pq.isEmpty()) 
        {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            if (d > dist[u]) continue;
            for (int[] nei : adj.get(u)) 
            {
                int v = nei[0], w = nei[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
