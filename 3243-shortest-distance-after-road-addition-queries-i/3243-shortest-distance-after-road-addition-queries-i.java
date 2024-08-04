import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[queries.length];
        Graph graph = new Graph(n);
        graph.addInitialEdges(n);

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.addEdge(u, v, 1); 
            distances[i] = graph.dijkstra(0, n - 1);
        }

        return distances;
    }
}

class Graph {
    private List<List<Edge>> adjacencyList;

    public Graph(int n) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addInitialEdges(int n) {
        for (int i = 0; i < n - 1; i++) {
            addEdge(i, i + 1, 1); 
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjacencyList.get(u).add(new Edge(v, weight));
    }

    public int dijkstra(int start, int destination) {
        int[] distances = new int[adjacencyList.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));
        boolean[] visited = new boolean[adjacencyList.size()];

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.node;

            if (visited[u]) continue;
            visited[u] = true;

            if (u == destination) return current.weight;

            for (Edge neighbor : adjacencyList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (!visited[v] && current.weight + weight < distances[v]) {
                    distances[v] = current.weight + weight;
                    pq.add(new Edge(v, distances[v]));
                }
            }
        }

        return distances[destination];
    }

    class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
