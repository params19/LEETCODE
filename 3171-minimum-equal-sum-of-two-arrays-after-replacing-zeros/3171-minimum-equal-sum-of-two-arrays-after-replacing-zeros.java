class Solution {
    public long minSum(int[] nums1, int[] nums2) {
       int cnt1=0;
       long sum1=0;
       int cnt2=0;
       long sum2=0;
       for(int a:nums1)
       {
        sum1+=a;
        if(a==0)
        {
            sum1++;
        cnt1++;
        }
       }
       for(int a:nums2)
       {
        sum2+=a;
        if(a==0)
        {
            sum2++;
        cnt2++;
        }
       }
       if(sum1==sum2)return sum1;
       else if(sum1<sum2)
       {
        if(cnt1!=0)
        return sum2;
        return -1;
       }
        if(cnt2!=0)
        return sum1;
        return -1;
    }
}