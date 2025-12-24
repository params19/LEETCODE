class Solution {
    int parent[];
    int rank[];
    public boolean[] distanceLimitedPathsExist(int n, int[][] edge, int[][] que) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        int m=que.length;
        int q[][]=new int[m][4];
        for(int i=0;i<m;i++)
        {
            q[i][0]=que[i][0];
            q[i][1]=que[i][1];
            q[i][2]=que[i][2];
            q[i][3]=i;
        }
        Arrays.sort(edge,(a,b)->Integer.compare(a[2], b[2]));
        Arrays.sort(q,(a,b)->Integer.compare(a[2], b[2]));
        int j=0;
        boolean res[]=new boolean[m];
        for(int i=0;i<m;i++)
        {
            int u=q[i][0];
            int v=q[i][1];
            int limit=q[i][2];
            int idx=q[i][3];
            while(j<edge.length&&edge[j][2]<limit)
            {
                union(edge[j][0],edge[j][1]);
                j++;
            }
            res[idx]=(find(u)==find(v));
        }
        return res;
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