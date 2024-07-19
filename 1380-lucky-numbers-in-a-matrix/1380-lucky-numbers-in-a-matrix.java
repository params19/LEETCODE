import java.util.*;
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(ischeck(matrix,i,j))
                {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
    private static boolean ischeck(int[][] matrix,int i,int j)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        for(int k=0;k<n;k++)
        {
            min=Math.max(min,matrix[k][j]);
        }
        for(int k=0;k<m;k++)
        {
            max=Math.min(max,matrix[i][k]);
        }
        return min==max;
    }
}