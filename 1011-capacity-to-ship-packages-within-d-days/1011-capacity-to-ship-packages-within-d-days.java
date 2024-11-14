class Solution {
    public int shipWithinDays(int[] arr, int d) {
        int ei=Arrays.stream(arr).sum();
        int si=Integer.MIN_VALUE;
        for(int i : arr)
        {
            si=Math.max(si,i);
        }
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(find(arr,mid,d)==true)
                ei=mid-1;
            else
                si=mid+1;
        }
        return si;
    }
    private static boolean find(int arr[], int ele, int d)
    {
        int n=arr.length;
        int cnt=1;
        int sum=0;
        for(int i : arr)
        {
            if(sum+i<=ele)sum+=i;
            else
            {
                cnt++;
                sum=i;
            }
        }
        if(cnt<=d)return true;
        return false;
    }
}