class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) { 
            return s;
        }
        String res = "";
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substr = s.substring(i, j);
                if (isPalindrome(substr) && substr.length() > len) {
                    len = substr.length();
                    res = substr;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
