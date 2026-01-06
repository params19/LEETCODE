class Solution {
    int n;
    int m;
    int ans=0;
    public int findLength(int[] nums1, int[] nums2) {
        n=nums1.length;
        m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                solve(nums1, nums2, i, j, dp);
            }
        }
        return ans;
    }
    public int solve(int nums1[], int nums2[], int i, int j, int dp[][])
    {
        if(i>=n||j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums1[i]==nums2[j])
        {
            dp[i][j]=1+solve(nums1, nums2, i+1, j+1,dp);
            ans=Math.max(ans,dp[i][j]);
        }
        else{
            dp[i][j]=0;
        }
        return dp[i][j];
    }
}