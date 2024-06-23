package top__150;

class Solution {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public int trailingZeroes(int n) {
       int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
