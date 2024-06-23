package top__150;

class Solution {
    //Time complexity:O(n*m)
    //Space complexity:O(n*m)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    //here we are incrementing the count of islands
                    cnt++;
                    dfs(grid,i,j);
                }
        }
    }
    return cnt;
    }
    private static void dfs(char[][] grid,int i,int j)
    {
        //standard dfs code
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0')
        {
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
