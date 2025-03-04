class Solution {
    public boolean checkPowersOfThree(int n) {
        String st=Integer.toString(n,3);
        int cnt=0;
        for(char ch : st.toCharArray())
        {
            if(ch=='0'||ch=='1')cnt++;
        }
        if(cnt==st.length())return true;
        return false;
    }

}