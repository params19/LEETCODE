class Solution {
    int n;
    int m;
    public boolean checkInclusion(String s1, String s2) {
        n=s1.length();
        m=s2.length();
        for(int i=0;i<=m-n;i++)
        {
            String curr=s2.substring(i,i+n);
            if(check(curr, s1)==true)return true;
        }
        return false;
    }
    public boolean check(String curr, String s1)
    {
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<n;i++)
        {
            freq1[curr.charAt(i)-'a']++;
            freq2[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!=freq2[i])return false;
        }
        return true;
    }
}