class Solution {
    //Time complexity : O(n)
    //Space complexity : O(1)
    public int maxArea(int[] height) {
        int maxw=0;
        int lp=0;
        int rp=height.length-1;
        while(lp<rp)
        {
            int ht=Math.min(height[lp],height[rp]);
            int w=rp-lp;
            int cw=ht*w;
            maxw=Math.max(cw,maxw);
            if(height[lp]<height[rp])
            {
                lp++;
            }
            else
            {
                rp--;
            }
        }
        return maxw;
    }
}