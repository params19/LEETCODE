//acha sawal hai :
class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> proc = new ArrayList<>();
        int ans = 0, m = 0; // m represents the max value of finished event so far

        // Populate the proc list with event start and end times
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];
            proc.add(new int[]{start, 1, value});  // 1 indicates start of an event
            proc.add(new int[]{end + 1, 0, value}); // 0 indicates end of an event
        }

        // Sort the proc list by time, and prioritize end events if times are equal
        proc.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Process the events
        for (int[] p : proc) {
            int time = p[0], isStart = p[1], value = p[2];
            if (isStart == 1) {
                ans = Math.max(ans, m + value);
            } else {
                m = Math.max(m, value);
            }
        }

        return ans;
    }
}