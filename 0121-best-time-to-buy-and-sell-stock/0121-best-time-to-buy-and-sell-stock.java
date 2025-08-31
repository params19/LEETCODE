class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        int ans=0;
        for(int i=n-1;i>=0;i--)
        {
            max=Math.max(prices[i], max);
            ans=Math.max(ans, max-prices[i]);
        }
        return ans;
    }
}