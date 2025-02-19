class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> que=new LinkedList<>();
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        que.add(0);
        vis[0]=true;
        int ans=0;
        ans++;
        while(!que.isEmpty())
        {
            int key=que.poll();
            for(int keys: rooms.get(key))
            {
                if(vis[keys]==false)
                {
                vis[keys]=true;
                ans++;
                que.add(keys);
                }
            }
        }
        return ans==n;
    }
}