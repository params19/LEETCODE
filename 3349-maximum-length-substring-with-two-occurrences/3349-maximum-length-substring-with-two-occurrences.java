class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int freq[]=new int[26];
        int l=0,r=0;
        int ans=0;
        while(r<n)
        {
            char ch=s.charAt(r);
            freq[ch-'a']++;
            while(freq[ch-'a']>2)
            {
                char chr=s.charAt(l);
                freq[chr-'a']--;
                l++;
            }
            ans=Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}