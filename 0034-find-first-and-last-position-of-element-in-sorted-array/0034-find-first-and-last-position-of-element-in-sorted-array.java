class Solution {
    public int[] searchRange(int[] nums, int target) {
      int t[]=new int[2];
        int k=target;
        int n=nums.length;
        int lb=lowerbound(nums,k);
        int ub=upperbound(nums,k);
        if((lb==n)||(nums[lb]!=target))
        {
            t[0]=-1;
            t[1]=-1;
            return t;
        }
        t[0]=lb;
        t[1]=ub-1;
        return t;
    }
    private static int lowerbound(int arr[],int target)
    {
        int n=arr.length;
        int si=0,ei=n-1;
        int ans=n;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(arr[mid]>=target)
            {
                ans=mid;
                ei=mid-1;
            }
            else
            {
                si=mid+1;
            }
        }
        return ans;
    }
    private static int upperbound(int arr[], int target)
    {
        int n=arr.length;
        int si=0,ei=n-1;
        int ans=n;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(arr[mid]>target)
            {
                ans=mid;
                ei=mid-1;
            }
            else
            {
                si=mid+1;
            }
        }
        return ans;
    }

}