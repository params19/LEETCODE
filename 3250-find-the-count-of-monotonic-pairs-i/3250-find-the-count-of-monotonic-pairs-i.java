class Solution {

    private int[][][] memo;

    private int compute(int[] arr, int idx, int prev1, int prev2) {
        if (idx >= arr.length) return 1;

        if (memo[idx][prev1][prev2] != -1) return memo[idx][prev1][prev2];

        int result = 0;
        for (int x = 0; x <= arr[idx]; x++) {
            int y = arr[idx] - x;
            if (x >= prev1 && y <= prev2) {
                result = (result + compute(arr, idx + 1, x, y)) % 1_000_000_007;
            }
        }

        return memo[idx][prev1][prev2] = result;
    }

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        memo = new int[n][51][51];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return compute(nums, 0, 0, 50);
    }
}
