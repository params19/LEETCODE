class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt=0;
        for(int i=0;i<words.length;i++)
        {
            String st=words[i];
            boolean flag=true;
            for(int j=0;j<st.length();j++)
            {
                if(allowed.indexOf(st.charAt(j))==-1)
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                cnt++;
        }
        return cnt;
    }
}