class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        //adj list 
        for (int[] edge : prerequisites) {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v); // u --> v
        }
        int Q = queries.length; // Number of queries

        List<Boolean> result = new ArrayList<>(Q);
        // Process each query
        for (int i=0;i<Q;i++) {
            int u=queries[i][0]; // Source
            int v=queries[i][1]; // Destination
            // Initialize visited array for DFS
            boolean[] vis=new boolean[numCourses];
            result.add(dfs(adj, u, v, vis)); 
        }
        return result;
    }
    //wahi dfs ka code
    private boolean dfs(List<List<Integer>> adj, int src, int dest, boolean[] vis) {
        vis[src] = true;
        if (src==dest) return true;//pahuch gaye 
        boolean is_reach=false;
        for (int adjNode : adj.get(src)) 
        {
            if (!vis[adjNode]) 
            {
                is_reach=is_reach||dfs(adj, adjNode, dest, vis);
            }
        }
        return is_reach;
    }
}
