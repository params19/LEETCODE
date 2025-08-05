class Solution {
    int n;
    int m;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        if(n==0||m==0||grid[0][0]!=0)return -1;
        // if(n==1 && m==1 && grid[0][0]==0) return 1;
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{0,0});
        int cnt=1;
        int directions[][]={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        grid[0][0]=1;
        while(!que.isEmpty())
        {
            int size=que.size();
            while(size-->0)
            {
            int curr[]=que.poll();
            int x=curr[0];
            int y=curr[1];
            if(x==n-1&&y==m-1)return cnt;
            for(int dir[]: directions)
            {
                int x_=x+dir[0];
                int y_=y+dir[1];
                if(x_>=0&&x_<n&&y_>=0&&y_<m&&grid[x_][y_]!=1)
                {
                    que.add(new int[]{x_,y_});
                    grid[x_][y_]=1;
                }
            }
            }
            cnt++;
        }
        return -1;
    }
}