class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int i : piles)
        {
            max=Math.max(max,i);
        }
        int si=1,ei=max;
        int ans=0;
        while(si<=ei)
        {
            int mid=si+(ei-si)/2;
            if(calculate(piles,mid)<=h)
            {
                ei=mid-1;
            }
            else
            {
                si=mid+1;
            }
        }
        return si;
    }
    private static int calculate(int piles[],int v)
    {
        int n=piles.length;
        int total=0;
        for(int i=0;i<n;i++)
        {
            total+=Math.ceil((double)piles[i]/v);
        }
        return total;
    }
}