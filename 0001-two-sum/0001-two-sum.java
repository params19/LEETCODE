class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force that will not work for higher test cases :
        // int a[]=new int[2];
        // int k=0;
        // int n=nums.length;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         if(nums[i]+nums[j]==target&&(i!=j))
        //         {
        //             a[k]=i;
        //             a[k+1]=j;
        //             break;
        //         }
        //     }
        // }
        // return a;

        //Optmised code :
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i = 0; i < nums.length; i++) 
        {
        int c= target-nums[i];
        if(mp.containsKey(c)) 
        {
        return new int[]{mp.get(c), i};
        }
        else
        {
        mp.put(nums[i], i);
        }
        }
        return new int[0];
    }
}