class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int pre=0;
        Map<Integer, Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++)
        {
            pre+=nums[i];
            int rem=pre%k;
            if(mp.containsKey(rem)){
                if(i-mp.get(rem)>=2){
                    return true;
                }
            }
            else{
                mp.put(rem,i);
            }
        }
        return false;
    }
}