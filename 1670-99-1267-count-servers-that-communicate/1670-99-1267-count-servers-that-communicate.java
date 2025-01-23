class Solution {
    public int countServers(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int cnt=0;
                    for(int r=0;r<m;r++)
                    {
                        if(r!=j&&grid[i][r]==1)cnt++;
                    }
                    if(cnt>=1){
                        ans++;
                    }
                    else
                    {
                    cnt=0;    
                    for(int c=0;c<n;c++)
                    {
                        if(c!=i&&grid[c][j]==1)cnt++;
                    }
                    if(cnt>=1)ans++;
                    }
                }
            }
        }
       return ans;
    }
}