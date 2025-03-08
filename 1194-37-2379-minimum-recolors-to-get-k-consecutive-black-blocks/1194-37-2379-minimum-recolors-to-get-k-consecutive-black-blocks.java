class Solution {
    public int minimumRecolors(String st, int k) {
        int n=st.length();
        // if(n==k)
        // {
        //     int ans=0;
        //     for(int i=0;i<n;i++)
        //     {
        //         char ch=st.charAt(i);
        //         if(ch=='W')ans++;
        //     }
        //     return ans;
        // }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++)
        {
            int cnt=0;
            int times=k;
            int start=i;
            while(times-->0)
            {
                if(st.charAt(start)=='W')cnt++;
                start++;
            }
            ans=Math.min(ans,cnt);
        }
        // if(ans==0)return 0;
        return ans;
    }
}