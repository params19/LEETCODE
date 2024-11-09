class Solution {
    public int smallestNumber(int n, int t) {
        int ans=0;
        for(int i=n;i<101;i++)
        {
            if(cal(i)%t==0)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
    private static int cal(int n)
    {
        int pro=1;
        for(int i=n;i>0;i/=10)
        {
            int r=i%10;
            pro*=r;
        }
        return pro;
    }
}