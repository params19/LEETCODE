class Solution {
    public String reverseVowels(String s) {
        String st="";
        int n=s.length();
        String vow="aeiouAEIOU";
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(vow.indexOf(ch)>=0)
            {
                st=ch+st;
            }
        }
        String rev="";
        int k=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(vow.indexOf(ch)>=0)
            {
                rev=rev+st.charAt(k);
                k++;
            }
            else
            {
                rev=rev+s.charAt(i);
            }
        }
        return rev;
    }
}