class Solution {
    Map<Integer, List<Integer>> map;
    boolean vis[];
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int i;
        int parent[] = new int[c + 1];
        int status[] = new int[c + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(status, 1);
        map = new HashMap<>();
        for (i = 0; i <= c; i++)
            map.put(i, new ArrayList<>());
        for (int[] x : connections) {
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        vis = new boolean[c + 1];
        ArrayList<TreeSet<Integer>> list = new ArrayList<>();
        for (i = 1; i <= c; i++) {
            if (!vis[i]) {
                TreeSet<Integer> set = new TreeSet<>();
                dfs(i, -1, set);
                list.add(set);
            }
        }
        for (i = 0; i < list.size(); i++) {
            for (int x : list.get(i)) {
                parent[x] = i;
            }
        }
        int q = queries.length;
        List<Integer> temp = new ArrayList<>();
        for (int[] x : queries) {
            int a = x[0];
            int b = x[1];
            if (a == 2) {
                if (status[b] == 1) {
                    int par = parent[b];
                    list.get(par).remove(b);
                    status[b] = 0;
                }
            } else {
                if (status[b] == 1) {
                    temp.add(b);
                } else {
                    int par = parent[b];
                    TreeSet<Integer> set = list.get(par);
                    if (set.isEmpty()) {
                        temp.add(-1);
                    } else {
                        temp.add(set.first());
                    }
                }
            }
        }
        int ans[] = new int[temp.size()];
        for (i = 0; i < temp.size(); i++)
            ans[i] = temp.get(i);
        return ans;
    }

    public void dfs(int x, int par, TreeSet<Integer> set) {
        if (vis[x]) return;
        vis[x] = true;
        set.add(x);
        for (int y : map.get(x)) {
            if (y != par) {
                dfs(y, x, set);
            }
        }
    }
}