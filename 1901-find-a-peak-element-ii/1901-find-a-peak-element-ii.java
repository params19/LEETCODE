class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int si=0, ei=m-1;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            int max=find_max(arr, n, m, mid);
            int left=mid-1>=0?arr[max][mid-1]:-1;
            int right=mid+1<m?arr[max][mid+1]:-1;
            if(arr[max][mid]>left && arr[max][mid]>right)
                return new int[]{max,mid};
            else if(arr[max][mid]<left)
                ei=mid-1;
            else 
                si=mid+1;
        }
        return new int[]{-1,-1};
    }
    private static int find_max(int arr[][], int n, int m, int mid)
    {
        int max=-1;
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i][mid]>max)
            {
                max=arr[i][mid];
                idx=i;
            }
        }
        return idx;
    }
}