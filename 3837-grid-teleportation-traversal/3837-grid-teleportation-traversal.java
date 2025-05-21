class Solution {
    public int minMoves(String[] mat) {
        int m=mat.length;
        int n=mat[0].length();
        Map<Character,List<int[]>> pm=new HashMap<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<mat[i].length();j++) {
                char cur=mat[i].charAt(j);
                if(cur>='A'&&cur<='Z') {
                    pm.computeIfAbsent(cur,k->new ArrayList<>()).add(new int[]{i,j});
                }
            }
        }
        int[][] dist=new int[m][n];
        for(int[] row:dist) Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0]=0;
        Deque<int[]> dq=new ArrayDeque<>();
        dq.addFirst(new int[]{0,0});
        int[] rd={-1,0,1,0};
        int[] cd={0,1,0,-1};
        while(!dq.isEmpty()) {
            int[] curr=dq.pollFirst();
            int r=curr[0];
            int c=curr[1];
            int s=dist[r][c];
            if(r==m-1&&c==n-1) return s;
            char cur=mat[r].charAt(c);
            if(cur>='A'&&cur<='Z'&&pm.containsKey(cur)) {
                for(int[] x:pm.get(cur)) {
                    int cr=x[0];
                    int cc=x[1];
                    if(dist[cr][cc]>s) {
                        dist[cr][cc]=s;
                        dq.addFirst(new int[]{cr,cc});
                    }
                }
                pm.remove(cur);
            }
            for(int i=0;i<4;i++) {
                int nr=r+rd[i];
                int nc=c+cd[i];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&mat[nr].charAt(nc)!='#') {
                    if(dist[nr][nc]>s+1) {
                        dist[nr][nc]=s+1;
                        dq.addLast(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}