class Solution {
    //acha sawal hai
    public boolean canBeValid(String s, String l) {
        int n=s.length();
        if(n%2!=0)return false;
        Stack<Integer> open=new Stack<>();//1 walon ko store kar do
        Stack<Integer> open_close=new Stack<>();// o walon ko store kardo
        for(int i=0;i<n;i++)
        {
            if(l.charAt(i)=='0')open_close.push(i);
            else if(s.charAt(i)=='(')open.push(i);
            else if(s.charAt(i)==')')
            {
                if(!open.isEmpty())open.pop();
                else if(!open_close.isEmpty())open_close.pop();
                else return false;
            }
        }
        while(!open.isEmpty()&&!open_close.isEmpty()&&open.peek()<open_close.peek())
        {
            open.pop();
            open_close.pop();
        }
        return open.isEmpty();
    }
}