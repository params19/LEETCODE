class Solution {
    public int[] getFinalState(int[] nums, int k, int m) {
        int n=nums.length;
        for(int j=0;j<k;j++)
        {
            int min=Integer.MAX_VALUE;
            int idx=0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]<min){
                    idx=i;
                    min=nums[i];
                }
            }
            nums[idx]*=m;
        }
        return nums;
    }
}