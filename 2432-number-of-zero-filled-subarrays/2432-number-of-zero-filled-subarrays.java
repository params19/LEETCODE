class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length;
        int cnt=0;
        long ans=0;
        int cn=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                cnt++;
            }
            else{
                ans+=(long)cnt*(cnt+1)/2;
                cnt=0;
            }
        }
        return ans+(long)cnt*(cnt+1)/2;
    }
}