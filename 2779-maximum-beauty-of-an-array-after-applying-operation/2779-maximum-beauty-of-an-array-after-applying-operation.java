class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> range = new ArrayList<>();
        for (int n : nums) {
            range.add(new int[]{n - k, n + k});
        }
        range.sort((a, b) -> Integer.compare(a[0], b[0]));
        int mx= 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int[] r : range) 
        {
            while (!deque.isEmpty() && deque.peekFirst() < r[0])                 {
                deque.pollFirst();
            }
            deque.offerLast(r[1]);

            mx = Math.max(mx, deque.size());
        }

        return mx;
    }
}