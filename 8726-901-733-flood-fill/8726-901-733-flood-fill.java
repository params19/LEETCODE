class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int val=image[sr][sc];
        dfs(sr,sc,image,color,val);
        return image;
    }
    private void dfs(int sr, int sc, int image[][],int color, int val)
    {
        int m=image.length;
        int n=image[0].length;
        if(sr<0||sr>m-1||sc<0||sc>n-1||image[sr][sc]!=val||image[sr][sc]==color)
        {
            return;
        }
        image[sr][sc]=color;
        dfs(sr+1,sc,image,color,val);
        dfs(sr-1,sc,image,color,val);
        dfs(sr,sc+1,image,color,val);
        dfs(sr,sc-1,image,color,val);
    }
}