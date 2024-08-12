class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return rec(0,n,nums,target);
    }
    private int rec(int i,int n,int[] nums,int target){
        if(i==n){
            if(target==0){
                return 1;
            }
            return 0;
        }
        return rec(i+1,n,nums,target-nums[i])+rec(i+1,n,nums,target+nums[i]);
    }
}