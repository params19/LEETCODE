class Solution {
    int n;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        long[][] dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, nums, dp, true);
    }
    public long solve(int idx, int[] nums, long[][] dp, boolean flag) {
        if (idx >= n) return 0;
        if (dp[idx][flag ? 1 : 0] != -1) return dp[idx][flag ? 1 : 0];
        long skip = solve(idx + 1, nums, dp, flag);
        int val = nums[idx];
        if (!flag) val = -val;
        long take = solve(idx + 1, nums, dp, !flag) + val;
        return dp[idx][flag ? 1 : 0] = Math.max(skip, take);
    }
}
