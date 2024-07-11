package top__150;
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=')')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                while(stack.peek()!='(')
                {
                    sb.append(stack.pop());
                }
                stack.pop();
                for(int j=0;j<sb.length();j++)
                {
                    stack.push(sb.charAt(j));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}