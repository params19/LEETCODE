class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int s=0,mx=Integer.MIN_VALUE;
        int r=0,l=0;
        while(r<n)
        {
            s+=nums[r];
            if(r-l+1<k)
            {
                r++;
            }
            else if(r-l+1==k)
            {
                mx=Math.max(mx,s);
                s-=nums[l];
                l++;
                r++;
            }
        }
        return (double)mx/k;
        }
}