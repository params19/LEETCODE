class Solution {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public void sortColors(int[] nums) {
        int l=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            l=Math.max(l,nums[i]);
        }
        int c[]=new int[l+1];
        for(int i=0;i<nums.length;i++)
        {
            c[nums[i]]++;
        }
        int j=0;
        for(int i=0;i<c.length;i++)
        {
            while(c[i]>0)
            {
                nums[j]=i;
                j++;
                c[i]--;
            }
        }
    }
}