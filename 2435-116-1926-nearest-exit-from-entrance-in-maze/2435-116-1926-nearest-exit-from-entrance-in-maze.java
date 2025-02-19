class Solution {
    public final int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public int nearestExit(char[][] maze, int[] ent) {
        int n=maze.length;
        int m=maze[0].length;
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{ent[0],ent[1]});
        maze[ent[0]][ent[1]]='+';
        int steps=0;
        while(!que.isEmpty())
        {
            int size=que.size();
            while(size-->0)
            {
                int[] temp=que.poll();
                int x=temp[0];
                int y=temp[1];
                if((x!=ent[0]||y!=ent[1])&&(x==0||x==n-1||y==0||y==m-1))
                {
                    return steps;
                }
                for(int[] dir : directions)
                {
                    int x_=dir[0]+x;
                    int y_=dir[1]+y;
                    if(x_>=0 && x_<n && y_>=0 && y_<m && maze[x_][y_]=='.')
                    {
                        que.add(new int[]{x_, y_});
                        maze[x_][y_]='+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}