import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ma=0;
        int nsr[]=new int[heights.length];
        int nsl[]=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        //next smaller right
        for(int i=heights.length-1;i>=0;i--)
        {
            while((!s.isEmpty())&&(heights[s.peek()]>=heights[i]))
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=heights.length;
            }
            else
            {
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s=new Stack<>();
        for(int i=0;i<heights.length;i++)
        {
            while((!s.isEmpty())&&(heights[s.peek()]>=heights[i]))
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsl[i]=-1;
            }
            else
            {
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        // max sum
        for(int i=0;i<heights.length;i++)
        {
            int ht=heights[i];
            int w=nsr[i]-nsl[i]-1;
            int ca=ht*w;
            ma=Math.max(ca,ma);
        }
        return ma;
    }
}