class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (ll.size() < n) {
            int next2 = ll.get(i2) * 2;
            int next3 = ll.get(i3) * 3;
            int next5 = ll.get(i5) * 5;
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ll.add(nextUgly);
            if (nextUgly == next2) i2++;
            if (nextUgly == next3) i3++;
            if (nextUgly == next5) i5++;
        }
        return ll.get(n - 1);
    }
}