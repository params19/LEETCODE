class Solution {
    public boolean isCircularSentence(String s) {
        int n=s.length();
        s=s.trim();
        if(s.charAt(0)!=s.charAt(n-1))return false;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
            {
                char ch1=s.charAt(i-1);
                char ch2=s.charAt(i+1);
                if(ch1!=ch2)return false;
            }
        }
        return true;
    }
}