class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int c1=0,c2=0,ans=0;
        for(int i : nums){
            if(i>0)c1++;
            else if(i<0)c2++;
        }
        return (int)Math.max(c1,c2);
    }
}