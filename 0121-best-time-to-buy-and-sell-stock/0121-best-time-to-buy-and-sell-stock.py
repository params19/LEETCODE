class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n=len(prices)
        mx=0
        ans=0
        for i in range(n-1,-1,-1):
            mx=max(prices[i],mx)
            ans=max(ans,mx-prices[i])
        return ans
        
