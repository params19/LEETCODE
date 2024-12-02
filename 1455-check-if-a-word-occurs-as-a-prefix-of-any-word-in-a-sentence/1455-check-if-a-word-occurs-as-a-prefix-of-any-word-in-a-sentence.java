class Solution {
    public int isPrefixOfWord(String s, String st) {
        int n = s.length();
        StringBuilder check = new StringBuilder(); 
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                check.append(ch);
            } else {
                cnt++;
                if (check.toString().startsWith(st)) return cnt;
                check.setLength(0);
            }
        }
        cnt++;
        if (check.toString().startsWith(st)) return cnt;

        return -1;
    }
}
