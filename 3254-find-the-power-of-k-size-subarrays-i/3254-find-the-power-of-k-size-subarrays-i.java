class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            if (is_consecutive(nums, i, k)) {
                res[i] = nums[i + k - 1];
            } else {
                res[i] = -1;
            }
        }
        
        return res;
    }

    public boolean is_consecutive(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
