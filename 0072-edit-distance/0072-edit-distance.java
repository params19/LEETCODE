class Solution {
    public int minDistance(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(m, n, s1, s2, dp);
    }
    public int solve(int m, int n, String s1, String s2, int dp[][])
    {
        if(m==0||n==0)return m+n;
        if(dp[m][n]!=-1)return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))return dp[m][n]=solve(m-1, n-1, s1, s2,dp);
        else{
            int insert= 1 + solve(m, n - 1, s1, s2, dp);
            int delete= 1 + solve(m - 1, n,s1, s2, dp);
            int replace= 1 + solve(m - 1, n - 1,s1, s2, dp);
            return dp[m][n]= Math.min(Math.min(insert, delete), replace);
        }
    }
}