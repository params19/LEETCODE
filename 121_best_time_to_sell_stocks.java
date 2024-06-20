class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        int bp=Integer.MAX_VALUE;
        int mp=0;
        for(int i=0;i<prices.length;i++)
        {
            if(bp<prices[i])
            {
                int p=prices[i]-bp;
                mp=Math.max(mp,p);
            }
            else
            {
                bp=prices[i];
            }
        }
        return mp;
    }
}