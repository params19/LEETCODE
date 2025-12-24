class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(graph,color,i))
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int graph[][],int color[],int node)
    {
        if(color[node]==-1)
            color[node]=1;
        for(int i=0;i<graph[node].length;i++)
        {
            if(color[graph[node][i]]==-1)
            {
                color[graph[node][i]]=1-color[node];
                if(!dfs(graph,color,graph[node][i]))
                    return false;
            }
            else if(color[graph[node][i]]==color[node])
                return false;
        }
        return true;
    }
}