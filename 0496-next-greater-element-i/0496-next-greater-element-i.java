class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int idx=search(nums1[i], nums2);
            boolean flag=false;
            for(int j=m-1;j>idx;j--)
            {
                if(nums2[j]>nums1[i])
                {
                    res[i]=nums2[j];
                    flag=true;
                }
            }
            if(flag==false)res[i]=-1;
        }
        return res;
    }
    public int search(int n, int nums2[])
    {
        for(int j=0;j<nums2.length;j++)
        {
            if(n==nums2[j])return j;
        }
        return -1;
    }
}