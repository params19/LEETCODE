package leetcode_contest;

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int c1=0,c2=0,height=0;
        for(int i=1;i<=100;i++)
        {
            if(i%2==1)
            c1+=i;
            else
            c2+=i;
            if(Math.max(c1,c2)<=Math.max(red,blue) && Math.min(c1,c2)<=Math.min(red,blue))
            {
            height=i;
            }
            else
            break;
        }
        return height;
    }
}
