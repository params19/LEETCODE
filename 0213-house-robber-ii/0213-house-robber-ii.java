class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int dp1[]=new int[n+1];
        int dp2[]=new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int c1=solve(0, n-2, nums, dp1);
        int c2=solve(1, n-1, nums, dp2);
        return Math.max(c1, c2);
    }
    public int solve(int idx, int end, int nums[], int dp[])
    {
        if(idx>end)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int take=nums[idx]+solve(idx+2, end, nums, dp);
        int leave=solve(idx+1, end, nums, dp);
        return dp[idx]=Math.max(take, leave);
    }
}