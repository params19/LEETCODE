class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int si=1;
        int ei=1000000000;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(find(nums, mid)<=t)
            {
                ei=mid-1;
            }
            else
            {
                si=mid+1;
            }
        }
        return si;
    }
    private static int find(int nums[], int ele)
    {
        int n=nums.length;
        int sum=0;
        for(int i : nums)
        {          
         int r = (int)Math.ceil((double)i/ele);
         sum+=r;
        }
        return sum;
    }
}