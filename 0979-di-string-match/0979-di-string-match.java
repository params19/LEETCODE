class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int arr[]=new int [n+1];
        Arrays.fill(arr, -1);
        int inc=0, dec=n;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='I')
            {
                arr[i]=inc;
                inc++;
            }
            else{
                arr[i]=dec;
                dec--;
            }
        }
        arr[n]=dec;
        return arr;
    }
}