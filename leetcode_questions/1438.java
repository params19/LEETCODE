class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int min = 0;
        int res = 0;
        while (right < n) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            if (max - min <= limit) {
                res = Math.max(res, right - left + 1);
            } else {
                left++;
            }
            right++;
        }
        return res;
    }
}