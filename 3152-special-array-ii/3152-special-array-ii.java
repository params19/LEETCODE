class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        if (n == 1) {
            boolean[] r = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                r[i] = true;
            }
            return r;
        }

        int[] s = new int[n];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + ((nums[i] % 2) == (nums[i - 1] % 2) ? 1 : 0);
        }

        boolean[] r = new boolean[queries.length];
        int index = 0;
        for (int[] res : queries) {
            int f = res[0];
            int t = res[1];
            int k = s[t] - s[f];
            r[index++] = (k == 0);
        }

        return r;
    }
}