class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int start_x=0;
        int start_y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)
                    cnt++;
                else if(grid[i][j]==1){
                    start_x=i;
                    start_y=j;
                }
            }
        }
        return backtrack(grid,start_x,start_y,cnt);
    }
    private int backtrack(int[][] grid,int i,int j,int cnt)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1)
            return 0;
        if(grid[i][j]==2)
        {
            if(cnt==-1)
                return 1;
            return 0;
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
        cnt--;
        int ans=backtrack(grid,i+1,j,cnt)+backtrack(grid,i-1,j,cnt)+backtrack(grid,i,j+1,cnt)+backtrack(grid,i,j-1,cnt);
        grid[i][j]=temp;
        return ans;
    }
}