class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        return Math.min((solve(0, n, cost, dp)), (solve(1, n, cost, dp)));
    }
    public int solve(int idx, int n, int cost[], int dp[])
    {
        if(idx>=n)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int take=cost[idx]+solve(idx+1, n, cost, dp);
        int leave=cost[idx]+solve(idx+2, n, cost, dp);
        return dp[idx]=Math.min(take,leave);
    }
}