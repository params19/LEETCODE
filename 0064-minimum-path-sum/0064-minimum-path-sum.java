class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(grid, dp, 0, 0, m, n);
    }
    public int solve(int grid[][], int dp[][], int i, int j, int m, int n)
    {
        if(i==m-1&&j==n-1)return grid[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==m-1)
        {
            return dp[i][j]=grid[i][j]+solve(grid, dp, i, j+1, m, n);
        }
        if(j==n-1)
        {
            return dp[i][j]=grid[i][j]+solve(grid, dp, i+1, j, m, n);
        }
        else{
            int down=solve(grid, dp, i, j+1, m, n);
            int right=solve(grid, dp, i+1, j, m, n);
            return  dp[i][j]=grid[i][j]+Math.min(down, right);
        }
    }
}