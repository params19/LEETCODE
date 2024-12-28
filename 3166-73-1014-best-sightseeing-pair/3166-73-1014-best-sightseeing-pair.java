class Solution {
    //aise questions me jisme eqaution given hoti hai try kara karo ki usko rearrange karlo
    //kaafi help hoti h isse 
    public int maxScoreSightseeingPair(int[] v) 
    {
    int n = v.length;
    int mx_arr[]=new int[n];
    int mx=Integer.MIN_VALUE;
    mx_arr[0]=v[0]+0;
    for(int i=1;i<n;i++)
    {
        mx_arr[i]=Math.max(mx_arr[i-1],v[i]+i);
    }
    int res=0;
    for(int i=1;i<n;i++)
    {
        int x = v[i] - i;
        int y = mx_arr[i - 1]; 
        res = Math.max(res, x + y);
    }
    return res;
    }
}
