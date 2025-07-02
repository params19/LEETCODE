class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int s1=0,s2=0,cnt=0;
        for(int i=0;i<n-1;i++)
        {
            s1+=nums[i];
            for(int j=i+1;j<n;j++)
            {
                s2+=nums[j];
            }
            if(Math.abs(s1-s2)%2==0){
                cnt++;
            }
            s2=0;
        }
        return cnt;
    }
}