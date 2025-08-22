class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vers[]=new int[n];
        int hors[]=new int[m];
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<m;j++)
            {
                sum+=grid[i][j];
            }
            vers[i]=sum;
        }
        for(int i=0;i<m;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {
                sum+=grid[j][i];
            }
            hors[i]=sum;
        }
        int f1=0,l1=0,f2=0,l2=0;
        for(int i=0;i<n;i++)
        {
            if(vers[i]==0){
                f1++;
            }
            else{
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(vers[i]==0){
                l1++;
            }
            else{
                break;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(hors[i]==0){
                f2++;
            }
                else{
                break;
                }
        }
        for(int i=m-1;i>=0;i--)
        {
            if(hors[i]==0){
                l2++;
            }
            else{
                break;
            }
        }
        return (n-f1-l1)*(m-f2-l2);
    }
}