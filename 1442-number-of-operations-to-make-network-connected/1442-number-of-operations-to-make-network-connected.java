class Solution {
    int parent[];
    int rank[];
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<(n-1))return -1;
        rank=new int[n];
        parent=new int[n];
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        int ans=n;
        for(int con[]: connections)
        {
            if(find(con[0])!=find(con[1]))
            {
                union(con[0], con[1]);
                ans--;
            }
        }
        return ans-1;
    }
    public int find(int i)
    {
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i]);
    }
    public void union(int x, int y)
    {
        int px=find(x);
        int py=find(y);
        if(px!=py)
        {
            if(rank[px]>rank[py])
            {
                parent[py]=px;
            }
            else if(rank[px]<rank[py])
            {
                parent[px]=py;
            }
            else{
                parent[py]=px;
                rank[px]++;
            }
        }
    }
}