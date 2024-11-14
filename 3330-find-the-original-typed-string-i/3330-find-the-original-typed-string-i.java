class Solution {
    public int possibleStringCount(String st) {
        int cnt=0;
        int n=st.length();
        for(int i=0;i<n-1;i++)
        {
            if(st.charAt(i)==st.charAt(i+1))cnt++;
        }
        return cnt+1;
    }
}