class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int leftmx[]=new int[n];
        int rightmx[]=new int[n];
        leftmx[0]=nums[0];
        rightmx[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        {
            leftmx[i]=Math.max(leftmx[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            rightmx[i]=Math.max(rightmx[i+1],nums[i]);
        }
        long ans=0;
        for(int i=1;i<n-1;i++)
        {
            long val=(long)(leftmx[i-1]-nums[i]);
            long v=(val*rightmx[i+1]);
            ans=Math.max(ans,v);
        }
        return ans;
    }
}