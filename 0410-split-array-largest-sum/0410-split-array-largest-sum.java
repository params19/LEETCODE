class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int l=0,h=0;
        for(int x: nums)
        {
            l=Math.max(x,l);
            h+=x;
        }
        int ans=h;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(cansplit(mid,nums,k))
            {
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean cansplit(int mid, int nums[], int k)
    {
        int s=0;
        int n=nums.length;
        int cnt=1;
        for(int i: nums)
        {
            if(s+i<=mid)
            {
                s+=i;
            }
            else{
                cnt++;
                s=i;
                if(cnt>k)return false;
            }
        }
        return true;
    }
}