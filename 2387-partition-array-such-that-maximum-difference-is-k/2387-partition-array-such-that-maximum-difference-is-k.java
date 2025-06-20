class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=0;
        int comp=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]-comp>k)
            {
                cnt++;
                comp=nums[i];
            }
        }
        return cnt+1;
    }
}