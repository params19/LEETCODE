class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjList=new HashMap<>();
        for(int i=0; i< equations.size(); i++) 
        {
            List<String> equation=equations.get(i);
            double value =values[i];
            String str1 =equation.get(0);
            String str2 =equation.get(1);
            constructAdjList(str1, str2, value, adjList);
            constructAdjList(str2, str1, 1/value, adjList);
        }
        double[] res = new double[queries.size()];
        for(int i=0; i< queries.size(); i++) 
        {
            res[i]=bfs(adjList, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private double bfs(Map<String, Map<String, Double>> adjList, String source, String dest) 
    {
        if(!adjList.containsKey(source) || !adjList.containsKey(dest)) {
            return -1.0;
        }
        if(source.equals(dest)) return 1.0;
        double mul = 1.0;
        Queue<String> queue =new LinkedList<>();
        Set<String> visited =new HashSet<>();
        Map<String, Double> productMap = new HashMap<>();
        queue.offer(source);
        visited.add(source);
        productMap.put(source, 1.0);
        while(!queue.isEmpty()) 
        {
            String current = queue.poll();
            for(String neighbor: adjList.get(current).keySet()) 
            {
                if(visited.contains(neighbor)) {
                    continue;
                }
                double newProduct =adjList.get(current).get(neighbor) * productMap.get(current);       
                if(neighbor.equals(dest)) 
                {
                    return newProduct;
                }
                productMap.put(neighbor, newProduct);
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return -1.0;
    }

    private void constructAdjList(String str1, String str2, double value, Map<String, Map<String, Double>> adjList) 
    {
            if(adjList.containsKey(str1)) {
                Map<String, Double> val = adjList.get(str1);
                val.put(str2, value);
                adjList.put(str1, val);
            } else {
                Map<String, Double> val = new HashMap<>();
                val.put(str2, value);
                adjList.put(str1, val);
            }
    }
}