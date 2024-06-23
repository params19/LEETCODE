package leetcode_contest;

public class q2_3195 {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int top=-1;
        int bottom=-1;
        int left=-1;
        int right=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(top==-1){
                        top=i;
                    }
                    bottom=i;
                }
            }
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(grid[i][j]==1){
                    if(left==-1){
                        left=j;
                    }
                    right=j;
                }
            }
        }
        int area=(right-left+1)*(bottom-top+1);
        return area;
    }
}