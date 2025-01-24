class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph){
        int[] nodeState = new int[graph.length]; 
        List<Integer> ans =new ArrayList<>();
        for(int i=0;i<nodeState.length; i++){
            if(nodeState[i] == 0) visit(i, graph, nodeState);
        }
        for(int i = 0;i<nodeState.length; i++){
            if(nodeState[i]==1)ans.add(i);
        }
        return ans;
    }
    private void visit(int node, int[][] graph, int[] nodeState){
        nodeState[node] = -1; // unsafe k liye
        for(int neighbor : graph[node]){
            if(nodeState[neighbor] == 0) visit(neighbor, graph, nodeState);
            if(nodeState[neighbor] == -1) return; // Cycle
        }
        nodeState[node] = 1; //safe h
    }
}