class Solution {
    public boolean canJump(int[] nums) {
       if(nums[0]==0)
       {
           return false;
       }
       else
       {
          int s=-1+nums[0];
          int i=s;
          int a=i;
          for(i=a;i<nums.length;i++)
          {
              if(i==(nums.length-1))
              {
                  return true;
              }
              else
              {
                  i=s+nums[i];
                  i--;
              }
          }
          return false;
       }
    }
}