class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjList = new ArrayList<>();

        // Step 1 - Build adjacency list
        buildAdjList(adjList, invocations, n);

        HashSet<Integer> nodesAlongPath = new HashSet<>(); // To track all affected (infected/suspicious) nodes

        // Step 2 - Find all infected/suspicious vertices using DFS
        dfs(k, adjList, new boolean[n], nodesAlongPath);

        List<Integer> res = new ArrayList<>();

        // Step 3 - Check if any unsuspicious node is invoking a suspicious one
        for (int[] invocation : invocations) {
            int invoker = invocation[0];
            int invoked = invocation[1];

            // If an unsuspicious node is invoking a suspicious one, return all vertices
            if (!nodesAlongPath.contains(invoker) && nodesAlongPath.contains(invoked)) {
                return generateResult(nodesAlongPath, res, n, false);
            }
        }

        // Step 4 - Remove suspicious nodes and return the rest
        return generateResult(nodesAlongPath, res, n, true);
    }

    private List<Integer> generateResult(HashSet<Integer> nodesAlongPath, List<Integer> res, int n, boolean toRemove) {
        for (int i = 0; i < n; i++) {
            if (toRemove) {
                if (!nodesAlongPath.contains(i)) {
                    res.add(i); // Add only non-suspicious nodes
                }
            } else {
                res.add(i); // Add all nodes if no suspicious invocation found
            }
        }
        return res;
    }

    private void dfs(int curr, List<List<Integer>> adjList, boolean[] visited, HashSet<Integer> nodesAlongPath) {
        if (visited[curr]) {
            return;
        }

        visited[curr] = true;
        nodesAlongPath.add(curr); // Mark the current node as suspicious
        for (int neighbor : adjList.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, nodesAlongPath); // Recursively visit neighbors
            }
        }
    }

    private void buildAdjList(List<List<Integer>> adjList, int[][] invocations, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            adjList.get(u).add(v); // Add directed edge from u to v
        }
    }
}
