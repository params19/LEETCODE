class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(n-1, coins, amount);
    }
    public int solve(int idx, int coins[], int sum)
    {
        if(sum==0)return 1;
        if(idx==0)return (sum%coins[0]==0)?1:0;
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        int take=0, nottake=0;
        if(coins[idx]<=sum)
        {
            take=solve(idx, coins, sum-coins[idx]); 
        }
        nottake=solve(idx-1, coins, sum);
        return dp[idx][sum]=take+nottake;
    }
}