class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int mx, int[][] queries) {
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n-1;i++)
        {
            int x=i;
            int y=i+1;
            if(nums[y]-nums[x]<=mx)
            {
                union(x, y, parent, rank);
            }
        }
        boolean res[]= new boolean[queries.length];
        int i=0;
        for (int q[]: queries) {
            boolean flag=(find(q[0], parent)==find(q[1], parent));
            res[i++]=flag;
        }
        return res;
    }
    public void union(int x, int y, int parent[], int rank[])
    {
        int px=find(x, parent);
        int py=find(y, parent);
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
    public int find(int i, int parent[])
    {
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i], parent);
    }
}