class Solution {
    int max = 0;
    public int longestPalindrome(String s, String t) {
        String s2 = new StringBuilder(t).reverse().toString();
        int n = s.length();
        int m = s2.length();
        
        boolean[][] palin1 = palinDp(s);
        boolean[][] palin2 = palinDp(s2);
        int[] dp1 = getDp(s, palin1);
        int[] dp2 = getDp(s2, palin2);
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    int next = 0;
                    if(i<n){
                        next = dp1[i];
                    }
                    if(j<m){
                        next = Math.max(next, dp2[j]);
                    }
                    max = Math.max(max, (2*dp[i][j])+next);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    public int[] getDp(String s, boolean[][] palin)
    {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            int len = 1;
            for(int j=i+1;j<n;j++){
                if(palin[i][j]){
                    len = Math.max(len, j-i+1);
                }
            }
            dp[i] = len;
            max = Math.max(max, len);
        }
        return dp;
    }

    public boolean[][] palinDp(String s){
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i=0;i<n;i++){
            isPalindrome[i][i] = true;
            if(i<n-1){
                if(s.charAt(i)==s.charAt(i+1)){
                    isPalindrome[i][i+1] = true;
                }
            }
        }
        for(int k=3;k<=n;k++){
            for(int i=0;i+k-1<n;i++){
                if(isPalindrome[i+1][i+k-2] && s.charAt(i)==s.charAt(i+k-1)){
                    isPalindrome[i][i+k-1]=true;
                }
            }
        }
        return isPalindrome;
    }

    public boolean isPalin(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
    
    public int longestCommonSubString(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}