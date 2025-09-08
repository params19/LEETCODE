class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n;i++)
        {
            if(check(i)==true&&check(n-i)==true)
            {
                return new int[]{i, n-i};
            }
        }
        return new int[]{0,0};
    }
    public boolean check(int v)
    {
        String st=Integer.toString(v);
        for(char ch : st.toCharArray())
        {
            if(ch=='0')return false;
        }
        return true;
    }
}