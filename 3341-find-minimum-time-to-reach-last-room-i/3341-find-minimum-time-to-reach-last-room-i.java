import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        long[] td = new long[n * m];
        Arrays.fill(td, Long.MAX_VALUE / 2);
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(state -> state.time));
        
        pq.add(new State(0, 0, 0));
        td[0] = 0;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            State current = pq.poll();
            long t = current.time;
            int r = current.row, c = current.col;

            if (r == n - 1 && c == m - 1) {
                return (int) t;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int next = nr * m + nc;
                    long nd = Math.max(t + 1, moveTime[nr][nc] + 1);
                    if (nd < td[next]) {
                        td[next] = nd;
                        pq.add(new State(nd, nr, nc));
                    }
                }
            }
        }

        return -1;
    }

    static class State {
        long time;
        int row, col;

        State(long time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
}