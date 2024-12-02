class Solution {
    public int isPrefixOfWord(String s, String st) {
        int n = s.length();
        String check=""; 
        int cnt = 0;
        for (int i = 0; i < n; i++) 
        {
            char ch = s.charAt(i);
            if (ch != ' ') 
            {
                check+=ch; 
            } else {
                cnt++;
                if (check.startsWith(st)) return cnt;
                check="";
            }
        }
        cnt++;
        if (check.startsWith(st)) return cnt;
        return -1;
    }
}
