class Solution {
    public int countPalindromicSubsequence(String s) {
        int n= s.length();
        int cnt= 0;
        for (char ch='a';ch<='z';ch++) 
        {
            int idx1=s.indexOf(ch);
            int idx2=s.lastIndexOf(ch);
            Set<Character> set = new HashSet<>();
            if (idx2-idx1>1) 
            {
                for(int i=idx1+1;i<idx2;i++)set.add(s.charAt(i));
            }
            cnt+=set.size();
        }
        return cnt;
    }
} 