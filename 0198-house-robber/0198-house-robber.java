class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, nums, dp);
    }
    public int solve(int idx, int n, int nums[], int dp[])
    {
        if(idx>=n)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int take=nums[idx]+solve(idx+2, n, nums, dp);
        int leave=solve(idx+1, n, nums, dp);
        return dp[idx]=Math.max(take, leave);
    }
}