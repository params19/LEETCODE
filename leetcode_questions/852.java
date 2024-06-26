class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //Brute force :
        //Time complexity: O(n)
        //Space complexity: O(1)
        int n=arr.length;
        int k=-1;
        int j=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>j)
            {
                j=arr[i];
                k=i;
            }
        }
        return k;
    }
}