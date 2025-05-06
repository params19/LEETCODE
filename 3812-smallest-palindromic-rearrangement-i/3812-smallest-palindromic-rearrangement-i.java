class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int freq[]=new int[26];
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']++;
        }
        String s1="";
        String extra="";
        String alpha="abcdefghijklmnopqrstuvwxyz";
        String s2="";
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2!=0)
            {
                int idx=i;
                extra+=alpha.charAt(i);
                freq[i]--;
            }
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2==0&&freq[i]>0)
            {
                for(int j=0;j<freq[i];j+=2)
                {
                    int idx=i;
                    s1+=alpha.charAt(i);
                }
            }
            // else{
            //     if(freq[i]>0)
            //     {
            //         for(int j=0;j<freq[i];j+=2)
            //         {
            //         int idx=i;
            //         extra+=alpha.charAt(i);
            //         }
            //         // if(freq[i]>1)extra+=alpha.charAt(i);
            //     }
            // }
        }
        String res=s1+extra+new StringBuilder(s1).reverse().toString();
        return res;
    }
}