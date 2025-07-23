class Solution {
    int n;
    public int minInsertions(String s) {
        n=s.length();
        int dp[][]=new int[n+1][n+1];
        for(int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        // if(n==1)return 1;
        return solve(s,0,n-1,dp);
    }
    public int solve(String s , int st, int en, int dp[][])
    {
        if(st>=en)return 0;
        // if(st==en)return 1;
        if(dp[st][en]!=-1)return dp[st][en];
        if(s.charAt(st)==s.charAt(en))return solve(s, st+1, en-1, dp);
        return dp[st][en]=1+Math.min(solve(s, st+1, en, dp), solve(s, st, en-1, dp));
    }
}