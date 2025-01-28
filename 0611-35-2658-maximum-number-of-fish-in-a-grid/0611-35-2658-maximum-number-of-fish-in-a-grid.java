//standard dfs
class Solution {
    private final static int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]>0)
                {
                    ans=Math.max(ans,dfs(i,j,grid,n,m));
                }
            }
        }
        return ans;
    }
    public static int dfs(int i,int j, int grid[][],int n, int m)
    {
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0)return 0;
        int vis=grid[i][j];
        grid[i][j]=0;
        for(int dir[]: directions)
        {
            int i1=i+dir[0];
            int j1=j+dir[1];
            vis+=dfs(i1,j1,grid,n,m);
        }
        return vis;
    }
}