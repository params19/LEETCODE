class Solution {
    public int subsetXORSum(int[] nums) {
        return recur(nums,0,0);
    }
    public int recur(int nums[], int i, int xor)
    {
        if(i==nums.length){
            return xor;
        }
        int in=recur(nums,i+1, xor^nums[i]);
        int out=recur(nums,i+1, xor);
        return in+out;
    }
}