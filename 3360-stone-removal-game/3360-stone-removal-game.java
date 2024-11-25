class Solution {
    public boolean canAliceWin(int n) {
        int val=10;
        int val2=9;
        int f=0;
        while(true)
        {
            if(f%2==0)
            {
                if(n>=val){
                    n-=val;
                    val-=2;
                }
                else return false;
            }
            else
            {
                if(n>=val2)
                {
                    n-=val2;
                    val2-=2;
                }
                else return true;
            }
            f++;
        }
    }
}