class Solution {
    public boolean canChange(String start, String target) {
         if (start.length() != target.length()) return false;

    int n = start.length();
    int i = 0, j = 0;

    while (i < n || j < n) {
        // Skip all '_' in start
        while (i < n && start.charAt(i) == '_') i++;
        // Skip all '_' in target
        while (j < n && target.charAt(j) == '_') j++;

        // If one string ends before the other
        if (i == n || j == n) return i == n && j == n;

        // Characters must match
        if (start.charAt(i) != target.charAt(j)) return false;

        // 'L' can only move left (i >= j)
        if (start.charAt(i) == 'L' && i < j) return false;

        // 'R' can only move right (i <= j)
        if (start.charAt(i) == 'R' && i > j) return false;

        i++;
        j++;
    }

    return true;
    }
}