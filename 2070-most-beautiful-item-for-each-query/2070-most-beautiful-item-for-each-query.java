import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] qq) {
        int q = qq.length;
        int n = items.length;
        int[] ans = new int[q];

        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int maxBeauty = 0;
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            maxBeauty = Math.max(maxBeauty, beauty);
            mp.put(price, maxBeauty); 
        }
        for (int i = 0; i < q; i++) {
            Integer closestPrice = mp.floorKey(qq[i]);
            if (closestPrice != null) {
                ans[i] = mp.get(closestPrice);
            } else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
}
