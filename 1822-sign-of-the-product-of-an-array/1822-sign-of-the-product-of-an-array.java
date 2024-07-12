class Solution {
    public int arraySign(int[] nums) {
        int count=0;
        int f=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            count++;
            if(nums[i]==0)
            f++;
        }
        if(f>0)
        return 0;
        else if(nums.length==1&&nums[0]>0)
        return 1;
        return signFunc(count);
    }
    private static int signFunc(int p)
    {
        if(p==0)
        return 0;
        else if(p%2==0)
        return 1;
        else
        return -1;
    }
}