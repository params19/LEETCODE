class Solution {
    public void rotate(int[] nums, int k) {
        // int n=nums.length;
        // k=k%n;
        // for(int i=1;i<=k;i++)
        // {
        //     int temp=nums[n-1];
        //     for(int j=n-2;j>=0;j--)
        //     {
        //         nums[j+1]=nums[j];
        //     }
        //     nums[0]=temp;

        //Extra array space
        int n=nums.length;
        int copy[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int shift=(i+k)%n;
            copy[shift]=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=copy[i];
        }
        
    }
}