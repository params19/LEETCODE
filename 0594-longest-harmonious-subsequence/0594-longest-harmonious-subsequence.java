class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int mx = 0;
        for (int key : mp.keySet()) {
            if (mp.containsKey(key + 1)) {
                mx = Math.max(mx, mp.get(key) + mp.get(key + 1));
            }
        }
        return mx;
    }
}
