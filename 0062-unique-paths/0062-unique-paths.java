class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for (int[] row : dp) {
        Arrays.fill(row, -1);
        }
        return solve(dp, 0, 0, m, n);
    }
    public int solve(int dp[][], int i, int j, int m, int n)
    {
        if(i==m-1&&j==n-1)return 1;
        if(i<0||i>=m||j<0||j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int right=solve(dp, i+1, j, m, n);
        int left=solve(dp, i, j+1, m, n);
        return dp[i][j]=right+left;
    }
}