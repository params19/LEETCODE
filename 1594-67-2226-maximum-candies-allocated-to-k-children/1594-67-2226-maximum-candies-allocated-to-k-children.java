class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int mx=0;
        long tot=0;
        for(int i : candies){
            tot+=i;
            mx=Math.max(i,mx);
        }
        if(tot<k)return 0;
        int l=1,r=mx;
        int res=0;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(validDistribute(candies, n, mid, k)){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public boolean validDistribute(int candies[], int n, int mid, long k)
    {
        long cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt+=candies[i]/mid;
            if(cnt>=k){
                return true;
            }
        }
        return false;
    }
}