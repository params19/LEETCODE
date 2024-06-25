package top__150;

import java.util.Arrays;

class Solution {
    //Time: O(n), Space: O(n)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int l2r[] = new int[n];
        int r2l[] = new int[n];
        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);
        for(int i=0;i<n;i++)
        {
            if(i!=0 && ratings[i]>ratings[i-1])
            {
                l2r[i] = l2r[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(i!=n-1 && ratings[i]>ratings[i+1])
            {
                r2l[i] = r2l[i+1]+1;
            }
        }
        int res = 0;
        for(int i=0;i<n;i++)
        {
            res += Math.max(l2r[i], r2l[i]);
        }
        return res;
    }
}
