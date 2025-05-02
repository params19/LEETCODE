class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m+1][n+1];
        for (int[] row : dp) {
        Arrays.fill(row, -1);
        }
        if(obstacleGrid[m-1][n-1]==1)return 0;
        return solve(dp, 0, 0, m, n, obstacleGrid);
    }
    public int solve(int dp[][], int i, int j, int m, int n, int obstacleGrid[][])
    {
        if(i==m-1&&j==n-1)return 1;
        if(i<0||i>=m||j<0||j>=n||obstacleGrid[i][j]==1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int right=solve(dp, i+1, j, m, n, obstacleGrid);
        int left=solve(dp, i, j+1, m, n, obstacleGrid);
        return dp[i][j]=right+left;
    }
}