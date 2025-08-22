class Solution {
    int n;
    int m;
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int prev=-1;
        int ans=Integer.MIN_VALUE;
        dp=new int[n][m];
        for(int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int cnt=dfs(i, j, prev, matrix);
                ans=Math.max(cnt, ans);
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int prev, int matrix[][])
    {
        if(i<0||i>n-1||j<0||j>m-1||matrix[i][j]<=prev)
        {
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        prev=matrix[i][j];
        int c1=dfs(i-1, j, prev, matrix);
        int c2=dfs(i+1, j, prev, matrix);
        int c3=dfs(i, j-1, prev, matrix);
        int c4=dfs(i, j+1, prev, matrix);
        return dp[i][j]=1+Math.max(c1, Math.max(c2, Math.max(c3, c4)));
    }
}