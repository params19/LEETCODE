import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, recStack)) {
                return false;
            }
        }
        
        return true;
    }

    private boolean dfs(int node, List<Integer>[] graph, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) {
            return true;
        }
        
        if (visited[node]) {
            return false;
        }
        
        visited[node] = true;
        recStack[node] = true;
        
        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, visited, recStack)) {
                return true;
            }
        }
        
        recStack[node] = false;
        return false;
    }
}