class Solution {
    public int[] maximumBeauty(int[][] items, int[] qq) {
        int q=qq.length;
        int n=items.length;
        int m=items[0].length;
        int ans[]=new int[q];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> mp=new TreeMap<>();
        int mb=0;
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];

            mb = Math.max(mb, beauty);
            mp.put(price, mb);
        }

        for (int i = 0; i < q; i++) {
             if(mp.containsKey(qq[i]))
            {
                ans[i]=mp.get(qq[i]);
            }
            else
            {
                 Integer prev = mp.lowerKey(qq[i]);
                if (prev != null) { 
                    ans[i] = mp.get(prev);
                } else {
                    ans[i]=0;
                }
            }
        }
        return ans;
    }
}