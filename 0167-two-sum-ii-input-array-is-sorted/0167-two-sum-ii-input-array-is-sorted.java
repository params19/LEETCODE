class Solution {
    public int[] twoSum(int[] nums, int t) {
        int n=nums.length;
         int l=0,r=n-1;
        while(l<=r)
        {
            if((nums[l]+nums[r])==t)return new int[]{l+1,r+1};
            if((nums[l]+nums[r])>t)r--;
            else l++;
        }
        return new int[]{0, 0};
    }
}