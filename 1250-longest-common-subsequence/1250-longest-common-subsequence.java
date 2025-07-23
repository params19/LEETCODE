class Solution {
    int n;
    int m;
    public int longestCommonSubsequence(String text1, String text2) {
        n=text1.length();
        m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(text1, text2, 0, 0, dp);
    }
    public int solve(String t1, String t2, int i, int j, int dp[][])
    {
        if(i>=n||j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(t1.charAt(i)==t2.charAt(j))return 1+solve(t1,t2,i+1,j+1,dp);
        return dp[i][j]=Math.max(solve(t1,t2,i+1,j,dp), solve(t1,t2,i,j+1,dp));
    }
}