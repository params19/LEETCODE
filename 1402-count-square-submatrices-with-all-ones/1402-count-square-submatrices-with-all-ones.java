class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        // int dp[][]=new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)continue;
                if(isvalid(i,j,matrix)){
                    matrix[i][j]+=Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                }
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
    public boolean isvalid(int i, int j, int mat[][])
    {
        if(i-1>=0&&j-1>=0&&mat[i-1][j-1]>0&&mat[i-1][j]>0&&mat[i][j-1]>0)
        {
            return true;
        }
        return false;
    }
}