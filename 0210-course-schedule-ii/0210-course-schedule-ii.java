class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int edge[]: pre)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)que.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        // int cnt=0;
        while(!que.isEmpty())
        {
            int curr=que.poll();
            topo.add(curr);
            // cnt++;
            for(int neigh: adj.get(curr))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)que.add(neigh);
            }
        }
        if(topo.size()!=n)return new int[0];
        int size=topo.size();
        int ans[]=new int[size];
        int i=0;
        while(size-->0)
        {
            ans[i]=topo.get(i);
            i++;
        }
        return ans;
    }
}