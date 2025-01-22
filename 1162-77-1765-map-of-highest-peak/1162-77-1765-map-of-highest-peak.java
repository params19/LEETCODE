// class Solution {
//     public int[][] highestPeak(int[][] mat) {
//         int n=mat.length;
//         int m=mat[0].length;
//         int ans[][]=new int[n][m];
//         int cnt=0;
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<m;j++)
//             {
//                 if(mat[i][j]==1){
//                     ans[i][j]=0;
//                     cnt++;
//                 }
//                 else ans[i][j]=1;
//             }
//         }
//         if(cnt==n*m)return ans;
        
//         while(arr[a][b])
//         for(int i=0;i<n;i++)
//         {
//             int d1=0,d2=0,d3=0,d4=0;
//             for(int j=0;j<m;j++)
//             {
//                 if(i-1>=0&&i-1<n)
//                 d1=Math.abs(ans[i][j]-ans[i-1][j]);
//                 if(i+1>=0&&i+1<n)
//                 d2=Math.abs(ans[i][j]-ans[i+1][j]);
//                 if(j-1>=0&&j-1<m)
//                 d3=Math.abs(ans[i][j]-ans[i][j-1]);
//                 if(j+1>=0&&j+1<m)
//                 d4=Math.abs(ans[i][j]-ans[i][j+1]);
//                 if(d1==0&&d2==0&&d3==0&&d4==0&&ans[i][j]!=0)
//                 {
//                     ans[i][j]=ans[i][j]+1;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++) 
            {
                ans[i][j]=n+m;
                if (mat[i][j]==1)ans[i][j]=0;
                else{
                    if (i>0)ans[i][j]=Math.min(ans[i][j], ans[i-1][j]+1);
                    if (j>0)ans[i][j]=Math.min(ans[i][j], ans[i][j-1]+1);
                }
            }
        }
        for (int i=n-1;i>=0;i--) 
        {
            for (int j=m-1;j>=0;j--) 
            {
                if (i<n-1) ans[i][j]=Math.min(ans[i][j], ans[i+1][j]+1);
                if (j<m-1) ans[i][j]=Math.min(ans[i][j], ans[i][j+1]+1);
            }
        }
        return ans;
    }
}
