class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        Arrays.sort(nums);
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[k]=nums[i+1];
            }
            else
            {
                arr[k]=nums[i-1];
            }
            k++;
        }
        return arr;
    }
}