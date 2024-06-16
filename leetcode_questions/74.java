class Solution {
    // TIME COMPLEXITY : O(n*m)
    // SPACE COMPLEXITY : O(n*m)
    public boolean searchMatrix(int[][] matrix, int target) {
        int a[]=new int[(matrix.length)*(matrix[0].length)];
        int c=0,f=0;

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {  
            a[c]=matrix[i][j];
            c++;
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(target==a[i])
            {
                f=1;
                break;
            }
            else
            {
                f=0;
            }
        }
        if(f==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}