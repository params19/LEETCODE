class Solution {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        int n = statements.length;

        for (int mask = 0; mask < (1 << n); mask++) 
        {
            if (helper(mask, n, statements)) 
            {
                ans = Math.max(ans, Integer.bitCount(mask));
            }
        }
        return ans;
    }

    private static boolean helper(int mask, int n, int[][] statements) 
    {
        for (int i = 0; i < n; i++) 
        {
            if ((mask & (1 << i)) != 0) 
            {
                for (int j = 0; j < n; j++) 
                {
                    boolean good = (mask & (1 << j)) != 0; 
                    if ((statements[i][j] == 0 && good) || (statements[i][j] == 1 && !good)) 
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
