class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] temp = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) 
        {
            temp[i] = nums[i % n];
        }
        int count=Arrays.stream(nums).sum();
        int i= 0;
        int j= 0;
        int curr= 0;
        int max=0;
        while(j<2*n) 
        {
            if (temp[j]==1) {
                curr++;
            }
            if (j-i+1>count) {
                curr-= temp[i];
                i++;
            }
            max= Math.max(max, curr);
            j++;
        }
        return count-max;
    }
}