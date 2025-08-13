class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1)return true;
        if(n%3!=0||n<=0)return false;
        int t=n;
        int cnt=0;
        while(n>1)
        {
            n/=3;
            cnt++;
        }
        if(Math.pow(3,cnt)==t)return true;
        return false;
    }
}