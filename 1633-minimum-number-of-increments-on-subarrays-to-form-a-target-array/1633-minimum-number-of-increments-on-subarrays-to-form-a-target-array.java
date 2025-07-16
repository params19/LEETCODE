class Solution {
    public int minNumberOperations(int[] heights) {
        int res = heights[0];
        for (int i = 1; i < heights.length; i++)
            res += Math.max(heights[i]-heights[i-1], 0);
        return res;
    }
}