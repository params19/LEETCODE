class Solution {
    public int maxFreqSum(String s) {
        int n=s.length();
        int freq[]=new int[26];
        int sum=0;
        int mx1=Integer.MIN_VALUE;
        int mx2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        String vow="aeiou";
        String com="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<26;i++)
        {
            if(vow.indexOf(com.charAt(i))>=0){
                mx1=Math.max(mx1,freq[i]);
            }
            else{
                mx2=Math.max(mx2,freq[i]);
            }
        }
        if(mx1==Integer.MIN_VALUE||mx2==Integer.MIN_VALUE)return (int)Math.max(mx1, mx2);
        return mx1+mx2;
    }
}