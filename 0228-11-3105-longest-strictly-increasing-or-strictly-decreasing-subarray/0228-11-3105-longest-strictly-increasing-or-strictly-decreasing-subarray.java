class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            int c1=0,c2=0;
            int j=i;
            while(j+1<n&&nums[j]<nums[j+1])
            {
                j++;
                c1++;
            }
            j=i;
            while(j+1<n&&nums[j]>nums[j+1])
            {
                j++;
                c2++;
            }
            ans=Math.max(ans,Math.max(c1,c2));
        }
        return ans+1;
    }
}