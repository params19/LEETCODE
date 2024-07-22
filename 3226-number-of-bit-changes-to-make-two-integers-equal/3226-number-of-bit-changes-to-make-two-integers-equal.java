class Solution {
    public int minChanges(int n, int k) {
            String b1 = Integer.toBinaryString(n);
            String b2 = Integer.toBinaryString(k);
            int maxLength = Math.max(b1.length(), b2.length());
        String n1 = String.format("%" + maxLength + "s", b1).replace(' ', '0');
        String k1= String.format("%" + maxLength + "s", b2).replace(' ', '0');
         int cnt=0;
         for(int i=0;i<maxLength;i++)
         {
            if(n1.charAt(i)=='1'&&k1.charAt(i)=='0')
            {
                cnt++;
            }
            else if(n1.charAt(i)=='0'&&k1.charAt(i)=='1')
            {
                return -1;
            }
         }
         return cnt;
    }
}