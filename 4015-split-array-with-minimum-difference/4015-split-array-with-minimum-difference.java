class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;
        if(n==2)
        {
            return Math.abs(nums[0]-nums[1]);
        }
        long s=0;
        for(int i:nums)
        {
            s+=i;
        }
        int max=-1;
        boolean prevd[]=new boolean[n];
        Arrays.fill(prevd, false);
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]>max)
            {
                prevd[i]=true;
                max=nums[i];
            }
            else{
                break;
            }
        }
        int mx=-1;
        long ans=Long.MAX_VALUE;
        long sum=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mx){
                sum+=nums[i];
                mx=nums[i];
                if(i<(n-1)&&prevd[i+1]==true)
                {
                    flag=true;
                    long diff=(s-sum);
                    long d2=Math.abs(sum-diff);
                    ans=Math.min(ans, d2);
                }
            }
            else{
                break;
            }
        }
        if(flag==false)return -1;
        return ans;
    }
}