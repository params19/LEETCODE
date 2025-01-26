class Solution {
    boolean visit[];
    boolean revVisit[];
    List<List<Integer>> rev;
    int dfs(int edges[],int n){
        if(visit[n]) return 0;
        visit[n] = true;
        return 1 + dfs(edges,edges[n]);
    }
    int dfs2(int e,int n){
        if(revVisit[n]) return 0;
        revVisit[n] = true;
        int max = 0;
        for(var c:rev.get(n)){
            if(c == e) continue;
            max = Math.max(max,1 + dfs2(e,c));
        }
        return max;
    }
    public int maximumInvitations(int[] edges) {
        visit = new boolean[edges.length];
        revVisit = new boolean[edges.length];
        int indeg[] = new int[edges.length];
        rev = new ArrayList<>();
        for(int i = 0;i < edges.length;i++) rev.add(new ArrayList<>());
        for(int i = 0;i < edges.length;i++){
            if(edges[i] != -1) indeg[edges[i]]++;
            rev.get(edges[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < edges.length;i++){
            if(indeg[i] == 0) q.add(i);
        }
        int topoCount = 0;
        for(;!q.isEmpty();){
            int node = q.poll();
            visit[node] = true;
            ++topoCount;
            if(edges[node] != -1){
                indeg[edges[node]]--;
                if(indeg[edges[node]] == 0){
                    q.add(edges[node]);
                }
            }
        }
        if(topoCount == edges.length) return -1;
        int max = 0;
        int sum = 0;
        for(int i = 0;i < edges.length;i++){
            if(!visit[i]){
                int cnt = dfs(edges,i);
                max = Math.max(max,cnt);
                if(cnt == 2){
                    int c1 = dfs2(edges[i],i);
                    int c2 = dfs2(i,edges[i]);
                    sum += 2 + c1 + c2;
                }
            }
        }
        return Math.max(max,sum);
    } 
}