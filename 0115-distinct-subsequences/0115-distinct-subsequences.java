class Solution {
    int n,m;
    public int numDistinct(String s, String t) {
        n=s.length()-1;
        m=t.length()-1;
        int dp[][]=new int[n+1][m+1];
        for(int row[]: dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(s, t, dp, n, m);
    }
    public int solve(String s, String t, int dp[][], int i, int j)
    {
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=(solve(s, t, dp, i-1, j-1)+solve(s, t, dp, i-1, j));
        }
        else{
            return dp[i][j]=solve(s, t, dp, i-1, j);
        }
    }
}