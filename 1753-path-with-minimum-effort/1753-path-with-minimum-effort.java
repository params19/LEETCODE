class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int res[][]=new int[n][m];
        int directions[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int row[] : res)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        res[0][0]=0;
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int diff=curr[0];
            int x=curr[1];
            int y=curr[2];
            for(int dir[]: directions)
            {
                int x_=x+dir[0];
                int y_=y+dir[1];
                if(x_>=0&&x_<n&&y_>=0&&y_<m)
                {
                    int newdiff=Math.max(diff, Math.abs(heights[x][y]-heights[x_][y_]));
                    if(res[x_][y_]>newdiff)
                    {
                        res[x_][y_]=newdiff;
                        pq.add(new int[]{newdiff, x_, y_});
                    }
                }
            }
        }
        return res[n-1][m-1];
    }
}