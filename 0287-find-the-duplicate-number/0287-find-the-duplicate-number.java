class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int f=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                f=nums[i];
                break;
            }
        }
        return f;
    }
}