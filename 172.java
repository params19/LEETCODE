class Solution {
    // TIME COMPLEXITY : O(logn)
    // SPACE COMPLEXITY : O(1)
    public int trailingZeroes(int n) {
       int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}