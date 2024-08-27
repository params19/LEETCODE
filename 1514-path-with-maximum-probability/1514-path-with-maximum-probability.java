import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create adjacency list for the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        // Distance array to store the max probability to reach each node
        double[] distance = new double[n];
        Arrays.fill(distance, 0.0);
        distance[start] = 1.0;

        // Priority queue (max-heap) for processing nodes
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1.0));

        // Dijkstra-like algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;

            // Early exit if we've reached the destination node
            if (node == end) {
                return prob;
            }

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;

                // If a higher probability path is found
                if (distance[nextNode] < prob * edgeProb) {
                    distance[nextNode] = prob * edgeProb;
                    pq.add(new Pair(nextNode, distance[nextNode]));
                }
            }
        }

        // If the end node is not reachable, return 0
        return distance[end];
    }
}

// Helper class to store node and probability
class Pair {
    int node;
    double prob;

    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}
