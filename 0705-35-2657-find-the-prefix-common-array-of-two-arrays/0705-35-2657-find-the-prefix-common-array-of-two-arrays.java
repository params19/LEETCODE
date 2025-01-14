class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int c[]=new int[n];
        int freq[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            freq[A[i]]++;
            freq[B[i]]++;
            int cnt=0;
            for(int j=0;j<n+1;j++)
            {
                if(freq[j]==2)cnt++;
            }
            c[i]=cnt;
        }
        return c;
    }
}