class Solution {
    public int minimumOperations(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        // if(m==1)return 0;
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(grid[j-1][i]>=grid[j][i])
                {
                    cnt+=grid[j-1][i]-grid[j][i]+1;
                    grid[j][i]=grid[j-1][i]+1;
                }
            }
        }
        return cnt;
    }
}