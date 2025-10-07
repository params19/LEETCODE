class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean vis[][]=new boolean[n][n];
        pq.add(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int t=curr[0], r=curr[1], c=curr[2];
            if(r==n-1&&c==n-1)return t;
            if(vis[r][c]==true)continue;
            vis[r][c]=true;
            for(int d[]: dir)
            {
                int r_=r+d[0];
                int c_=c+d[1];
                if(r_>=0&&r_<n&&c_>=0&&c_<n&&vis[r_][c_]==false)
                {
                    int nt=Math.max(t,grid[r_][c_]);
                    pq.add(new int[]{nt,r_,c_});
                }
            }
        }
        return -1;
    }
}