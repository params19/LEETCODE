class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ll=new ArrayList<>();
        int cnt=1;
        while(n>0)
        {
            int i=n%10;
            n=n/10;
            if(i!=0)
            {
            ll.add(i*cnt);
            }
            cnt=cnt*10;
        }
        int m=ll.size();
        int res[]=new int[m];
        int k=m-1;
        for(int i=0;i<m;i++)
        {
            res[k]=ll.get(i);
            k--;
        }
        return res;
    }
}