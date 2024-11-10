class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int si=0,ei=n-1;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)si=mid+1;
            else ei=mid-1;
        }
        return si+k;
    }
}