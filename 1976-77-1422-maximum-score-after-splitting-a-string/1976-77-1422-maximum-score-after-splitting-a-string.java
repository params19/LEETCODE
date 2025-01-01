class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int ans=0;
        int idx1=s.indexOf('1');
        int idx2=s.indexOf('0');
        if(idx1==-1||idx2==-1)
        {
            return n-1;
        }
        for(int i=1;i<n;i++)
        {
            String s1=s.substring(0,i);
            String s2=s.substring(i);
            int cnt0 =(int)s1.chars().filter(c -> c == '0').count();
            int cnt1 =(int)s2.chars().filter(c -> c == '1').count();
            ans=Math.max(ans,cnt0+cnt1);
        }
        // if(ans==n)return ans-1;
        return ans;
    }
}