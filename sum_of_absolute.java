class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] arr = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        int c = nums.length;
        for(int i = 0;i<nums.length;i++){
            arr[i] = sum - c * nums[i];
            //here we multiplying by 2 because it is contributing to the sum twice
            sum = sum - 2 * nums[i];
            //here we are decreasing the value of c by 2 because we are moving to the next element
            c -=2;
        }
        return arr;
    }
}