class Solution {
    int parent[], rank[];
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        int grp=n;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(issim(strs[i],strs[j])&&find(i)!=find(j))
                {
                    grp--;
                    union(i,j);
                }
            }
        }
        return grp;
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
            else
            {
                parent[px]=py;
                rank[py]++;
            }
        }
    }
    public int find(int i)
    {
        if(parent[i]==i)
        {
            return i;
        }
        return parent[i]=find(parent[i]);
    }
    public boolean issim(String x, String y)
    {
        int n=x.length();
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(x.charAt(i)!=y.charAt(i))
            {
                cnt++;
            }
        }
        return (cnt==0||cnt==2);
    }
}