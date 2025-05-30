class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row,-1);
        return res(dungeon,n,m,0,0,dp);
        
    }
    private static int res(int[][] ress, int n, int m, int i, int j, int[][] dp){
        if(i>= n || j>= m) return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1) return Math.max(1,1-ress[i][j]);
        if(dp[i][j] != -1) return dp[i][j];
        int right = res(ress, n, m, i, j+1, dp);
        int down = res(ress, n, m, i+1, j, dp);
        int maxx = Math.min(right,down);
        int a = maxx - ress[i][j];
        return dp[i][j] = Math.max(1,a);
    }
}