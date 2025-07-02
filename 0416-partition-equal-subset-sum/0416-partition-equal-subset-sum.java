class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for (int num : nums)sum+=num;
        if (sum % 2 != 0) return false;
        int target=sum/2;
        dp=new int[n][target + 1]; 
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, nums, target);
    }

    public boolean solve(int i, int[] nums, int target) {
        if (target==0) return true;
        if (i==nums.length || target<0) return false;
        if (dp[i][target]!=-1) return dp[i][target]==1;
        boolean take=solve(i + 1, nums, target-nums[i]);
        boolean skip=solve(i + 1, nums, target);
        dp[i][target] = (take || skip) ? 1 : 0;
        return take || skip;
    }
}
