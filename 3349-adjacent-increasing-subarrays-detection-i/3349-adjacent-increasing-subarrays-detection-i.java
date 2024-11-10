class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        
        for (int i = 0; i <= n - 2 * k; i++) {
            boolean increasing = true;
            
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    increasing = false;
                    break;
                }
            }
            
            if (increasing && check(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(List<Integer> nums, int start, int k) {
        int n = nums.size();
        
        for (int j = start; j < start + k - 1 && j < n - 1; j++) {
            if (nums.get(j) >= nums.get(j + 1)) {
                return false;
            }
        }
        return true;
    }
}
