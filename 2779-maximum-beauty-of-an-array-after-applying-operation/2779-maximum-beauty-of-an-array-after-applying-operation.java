class Solution {
    public int maximumBeauty(int[] nums, int k) {
       int maxNum = Arrays.stream(nums).max().orElse(0);
        int minNum = Arrays.stream(nums).min().orElse(0);
        int range = maxNum + k + 1;
        int[] diff = new int[range];
        for (int num : nums) {
            int start = Math.max(0, num - k);
            int end = num + k + 1; 
            diff[start]++;
            if (end < range) {
                diff[end]--;
            }
        }
        int maxFreq = 0, currFreq = 0;
        for (int value : diff) {
            currFreq += value;
            maxFreq = Math.max(maxFreq, currFreq);
        }

        return maxFreq;
    }
}