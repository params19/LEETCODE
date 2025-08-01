class Solution {
    int n;
    int m;
    public boolean isMatch(String s, String p) {
        n=s.length()-1;
        m=p.length()-1;
        Boolean dp[][]=new Boolean[n+1][m+1];
        return solve(s, p, dp, n, m);
    }
    public boolean solve(String s, String p, Boolean dp[][], int i, int j)
    {
        if(i<0&&j<0)return true;
        if(i>=0&&j<0)return false;
        if(i<0&&j>=0){
            for(int k=j;k>=0;k--)
            {
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
            return dp[i][j]=solve(s, p, dp, i-1, j-1);
        }
        else if(p.charAt(j)=='*')
        {
            return dp[i][j]=solve(s, p, dp, i-1, j)||solve(s, p, dp, i, j-1);
        }
        else{
            return false;
        }
    }
}