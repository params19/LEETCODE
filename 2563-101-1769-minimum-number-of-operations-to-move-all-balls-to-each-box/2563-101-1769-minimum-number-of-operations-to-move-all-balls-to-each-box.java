class Solution {
    public int[] minOperations(String boxes) {
        int m[]=new int[boxes.length()];
       for(int i=0;i<boxes.length();i++)
       {
           int f=0;
           for(int j=0;j<boxes.length();j++)
           {
               if(j!=i)
               {
               char ch=boxes.charAt(j);
               if(ch=='1')
               {
                   f+=(int)Math.abs(i-j);
               }
               }
           }
           m[i]=f;
       }
       return m; 
    }
}