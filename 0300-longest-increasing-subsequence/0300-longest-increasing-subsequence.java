class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(dp, nums, 0, -1);
    }
    public int solve(int dp[][],int nums[], int idx, int prev)
    {
        if(idx>=nums.length)return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        int take=0;
        if(prev==-1||nums[idx]>nums[prev]){
            take=1+solve(dp, nums, idx+1, idx);
        }
        int leave=solve(dp, nums, idx+1, prev);
        return dp[idx][prev+1]=Math.max(take, leave);
    }
}