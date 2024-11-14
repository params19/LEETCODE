class Solution {
    public int minDays(int[] arr, int m, int k) {
        int si=Integer.MAX_VALUE;
        int ei=Integer.MIN_VALUE;
        long n=arr.length;
        for(int i : arr)
        {
            si=Math.min(si,i);
            ei=Math.max(ei,i);
        }
        long p=(long)k*m;
        if(p>n)return -1;
        // if(k*m>n)return -1;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(search(mid, arr,m,k)==true)
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
        private static boolean search(int i,int arr[], int m, int k)
        {
            int n=arr.length;
            int cnt=0, ans=0;
            for(int j=0;j<n;j++)
            {
                if(arr[j]<=i)cnt++;
                else
                {
                    ans+=(cnt/k);
                    cnt=0;
                }
            }
            ans+=(cnt/k);
            if(ans>=m)return true;
            return false;
        }
}