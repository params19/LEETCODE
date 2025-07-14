class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++)
        {
            int diff=nums[i+k-1]-nums[i];
            ans=Math.min(diff, ans);
        }
        return ans;
    }
}