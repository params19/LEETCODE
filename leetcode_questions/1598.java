class Solution {
    public int minOperations(String[] logs) {
        int n=logs.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            String st=logs[i];
            if(st.endsWith("/")&&(!st.startsWith(".")))
            {
                count++;
            }
            else if(st.equals("./"))
            {
                count=count;
            }
            else{
                count--;
                count=Math.max(count,0);
            }
        }
        if(count<0)
        return 0;
        else
        return count;
    }
}