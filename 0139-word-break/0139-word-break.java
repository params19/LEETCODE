class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> ss= new HashSet<>(dict);
        int n=s.length();
        Boolean dp[]=new Boolean[n+1];
        return solve(dp, 0, s, ss);
    }
    public boolean solve(Boolean dp[], int idx, String s, Set<String> ss)
    {
        if(idx==s.length())return true;
        if(dp[idx]!=null)return dp[idx];
        for(int i=idx+1;i<=s.length();i++)
        {
            String str=s.substring(idx,i);
            if(ss.contains(str)&&solve(dp,i,s,ss))return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}