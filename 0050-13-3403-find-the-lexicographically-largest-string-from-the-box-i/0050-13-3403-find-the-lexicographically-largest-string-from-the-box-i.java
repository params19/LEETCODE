class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1)
            return word;
        int maxLen = n - numFriends + 1;
        String ans = "";
        for (int i=0; i<n; i++) {
            String curr = word.substring(i, Math.min(n, i+maxLen));
            if (curr.compareTo(ans) > 0)
                ans = curr;
        }
        return ans;
    }
}