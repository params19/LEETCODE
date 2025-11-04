class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    List<Integer> ll=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0);
        return ans;
    }
    public void dfs(int graph[][], int node)
    {
        ll.add(node);
        if(node==graph.length-1){
            ans.add(new ArrayList<>(ll));
        }
        else{
            for(int nodes:graph[node])
            {
                dfs(graph,nodes);
            }
        }
        ll.remove(ll.size()-1);
    }
}