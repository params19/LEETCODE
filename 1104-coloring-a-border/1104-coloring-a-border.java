class Solution {
    int res[][];
    int n,m;
    int org;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        n=grid.length;
        m=grid[0].length;
        res=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res[i][j]=grid[i][j];
            }
        }
        org=grid[row][col];
        dfs(res, row, col, grid[row][col], grid);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(res[i][j]==0)
                {
                    if(isbound(i, j)==true||isadj(grid, i, j))
                    {
                        res[i][j]=color;
                    }
                    else{
                        res[i][j]=org;
                    }
                }
            }
        }
        return res;
    }
    public boolean isbound(int i, int j)
    {
        if(i==0||j==0||i==n-1||j==m-1)return true;
        return false;
    }
    public boolean isadj(int grid[][], int i, int j) 
    {
    if(i > 0 && grid[i - 1][j] != org)return true;
    if(i < n - 1 && grid[i + 1][j] != org)return true;
    if(j > 0 && grid[i][j - 1] != org)return true;
    if(j < m - 1 && grid[i][j + 1] != org)return true;
    return false;
    }
    public void dfs(int res[][], int row, int col, int color, int grid[][])
    {
        if(row<0||row>=n||col<0||col>=m||grid[row][col]!=color||res[row][col]==0)return;
        res[row][col]=0;
        dfs(res, row+1, col, color, grid);
        dfs(res, row, col+1, color, grid);
        dfs(res, row-1, col, color, grid);
        dfs(res, row, col-1, color, grid);
    }
}