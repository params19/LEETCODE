class Solution {
    public int maxConsecutiveAnswers(String st, int k) {
        int n=st.length();
        int l=0,r=0;
        int freq[]=new int[26];
        int ans=0;
        boolean flag=false;
        while(r<n)
        {
            freq[st.charAt(r)-'A']++;
            while(Math.min(freq['T'-'A'], freq['F'-'A'])>k)
            {
                flag=true;
                freq[st.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans, r-l+1);
            r++;
        }
        if(flag==false)return n;
        return ans;
    }
}