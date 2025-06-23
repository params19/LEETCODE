class Solution {
    public int countKDifference(int[] nums, int k) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((int)Math.abs(nums[j]-nums[i])==k)cnt++;
            }
        }
        return cnt/2;
    }
}