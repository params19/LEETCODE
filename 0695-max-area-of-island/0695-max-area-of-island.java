class Solution {
    int n;
    int m;
    int cnt=0;
    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    ans=Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }
    public int dfs(int grid[][], int i, int j)
    {
        if(i<0||i>=n||j<0||j>=m||grid[i][j]!=1)return 0;
        grid[i][j]=-1;
        return 1+dfs(grid, i+1, j)+dfs(grid, i-1, j)+dfs(grid, i, j+1)+dfs(grid, i, j-1);
    }
}