class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for (int[][] arr : dp) 
        {
            for (int[] nums : arr) 
            {
                Arrays.fill(nums, -1);
            }
        }
        return f(0, 1, k, prices, dp, n);
    }
    int f(int idx, int buy, int cap , int[] prices, int[][][] dp, int n)
    {
        if(cap==0)return 0;
        if(idx==n)return 0;
        int profit =0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        if(buy==1)
        {
            profit=Math.max(-prices[idx]+f(idx+1, 0, cap, prices, dp, n), f(idx+1, 1, cap, prices, dp, n));
        }
        else{
            profit=Math.max(prices[idx] + f(idx+1, 1, cap-1, prices, dp, n), f(idx+1, 0, cap, prices, dp, n));
        }
    return dp[idx][buy][cap]=profit;
    }
}