class Solution {
    int n;
    int m;
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    if(dfs(grid, i, j)==true)cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean dfs(int grid[][], int i, int j)
    {
        if(i<0||i>=n||j<0||j>=m)return false;
        if(grid[i][j]==1)return true;
        grid[i][j]=1;
        boolean a=dfs(grid, i+1, j);
        boolean b=dfs(grid, i-1, j);
        boolean c=dfs(grid, i, j+1);
        boolean d=dfs(grid, i, j-1);
        return a&&b&&c&&d;
    }
}