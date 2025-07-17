class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5=0,c10=0;
        for (int bill : bills) 
        {
            if (bill==5) {
                c5++;
            } else if (bill==10) {
                if (c5==0)return false;
                c5--;
                c10++;
            }else {
                if (c10>0&&c5>0){
                    c10--;
                    c5--;
                } else if(c5>=3) {
                    c5-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}