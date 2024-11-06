class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int f=-1;
        if(n==1)return 0;
        else if(n==2){
            if(nums[0]<nums[1])return 1;
            return 0;
        }
        else
        {
            for(int i=1;i<n-1;i++)
            {
                if(nums[i-1]<nums[i]&&nums[i]>nums[i+1])
                {
                 f=i;
                 break;
                }
            }
        }
        if(f!=-1)return f;
        else
        {
            if(nums[n-1]>nums[n-2])return n-1;
            return 0;
        }
    }
}