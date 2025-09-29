class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0, costs, n, dp);
    }
    public int solve(int idx, int costs[], int n, int dp[])
    {
        if(idx==n)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int one=(costs[idx]+1)+solve(idx+1, costs, n, dp);
        int two=idx+2<=n?(costs[idx+1]+4)+solve(idx+2, costs, n, dp):Integer.MAX_VALUE;
        int three=idx+3<=n?(costs[idx+2]+9)+solve(idx+3, costs, n, dp):Integer.MAX_VALUE;
        return dp[idx]=Math.min(one, Math.min(two, three));
    }
}