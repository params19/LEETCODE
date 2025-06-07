class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        for(int i=1;i<=k;i++)
        {
            int temp=nums[n-1];
            for(int j=n-2;j>=0;j--)
            {
                nums[j+1]=nums[j];
            }
            nums[0]=temp;
        }
    }
}