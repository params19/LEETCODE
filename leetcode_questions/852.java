class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //Brute force :
        //Time complexity: O(n)
        //Space complexity: O(1)
        // int n=arr.length;
        // int k=-1;
        // int j=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++)
        // {
        //     if(arr[i]>j)
        //     {
        //         j=arr[i];
        //         k=i;
        //     }
        // }
        // return k;

        //Optimal solution:
        //Time complexity: O(logn)
        //Space complexity: O(1)
        int low=0;
        int high=arr.length-1;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid+1])
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}