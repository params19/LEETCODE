class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i : nums)sum+=i;
        if(sum%2!=0)return false;
        int tar=sum/2;
        Boolean dp[][]=new Boolean[n+1][sum+1];
        return solve(dp, nums, n-1, tar);
    }
    public Boolean solve(Boolean dp[][], int[] nums, int i, int tar)
    {
        if(tar==0)return true;
        if(i==0)return false;
        if(dp[i][tar]!=null)return dp[i][tar];
        if(nums[i]<=tar)
        {
            dp[i][tar]=solve(dp, nums, i-1, tar-nums[i])||solve(dp, nums, i-1, tar);
        }
        else{
            dp[i][tar]=solve(dp, nums, i-1, tar);
        }
        return dp[i][tar];
    }
}