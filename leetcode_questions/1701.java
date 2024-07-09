class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long totalWaitTime = 0;
        long currentTime = 0;
        
        for (int i = 0; i < n; i++) 
        {
            int arrival = customers[i][0];
            int timeToServe = customers[i][1];
            currentTime = Math.max(currentTime, arrival) + timeToServe;
            totalWaitTime += currentTime - arrival;
        }
        return (double) totalWaitTime / n;
    }
}
