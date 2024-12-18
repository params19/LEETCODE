class Solution {
    public int[] finalPrices(int[] p) {
        int n=p.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int v=-1;
            for(int j=i+1;j<n;j++)
            {
                if(p[j]<=p[i])
                {
                    v=p[j];
                    break;
                }
            }
            if(v!=-1)p[i]=p[i]-v;
        }
        return p;
    }
}