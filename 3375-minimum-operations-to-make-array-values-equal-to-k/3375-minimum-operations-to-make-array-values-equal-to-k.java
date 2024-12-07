class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt=0;
        Set<Integer> ss=new HashSet<>();
        for(int i : nums)ss.add(i);
        for(int i : ss){
            if(i<k)return -1;
            if(i>k)cnt++;
        }
        // if(cnt==0||!(nums.length==1&&k==1))return -1;
        return cnt;
    }
}