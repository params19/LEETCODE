class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
      int low = arrays.get(0).get(0);
        int high = arrays.get(0).get(arrays.get(0).size() - 1);
        int diff = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int l = arr.get(0);
            int h = arr.get(arr.size() - 1);

            diff = Math.max(diff, Math.abs(l - high));
            diff = Math.max(diff, Math.abs(h - low));
            low = Math.min(low, l);
            high = Math.max(high, h);
        }

        return diff;
    }
}