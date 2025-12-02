class Solution {
    public long maxProfit(int[] p, int[] st, int k) {
        int n=p.length;
        long pre[]=new long[n];
        long og[]=new long[n];
        long s=0,os=0;
        for(int i=0;i<n;i++)
        {
            s+=p[i];
            pre[i]=s;
            os+=(p[i]*st[i]);
            og[i]=os;
        }
        long ans=og[n-1];
        for(int i=k-1;i<n;i++)
        {
            long lws=0;
            long rws=0;
            long l=pre[i]-pre[i-(k/2)];
            if(i-k>=0)
            {
                lws=og[i-k];
            }
            rws=og[n-1]-og[i];
            ans=Math.max(ans,rws+lws+l);
        }
        return ans;
    }
}