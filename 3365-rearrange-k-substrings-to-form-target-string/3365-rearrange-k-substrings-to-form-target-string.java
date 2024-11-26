class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int cnt=n/k;
        Map<String, Integer> mp1 = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < n; i += cnt) 
        {
            String s1 = s.substring(i, i + cnt);
            mp1.put(s1, mp1.getOrDefault(s1, 0) + 1);
        
            String t1 = t.substring(i, i + cnt);
            mp2.put(t1, mp2.getOrDefault(t1, 0) + 1);
        }
        return mp1.equals(mp2);
    }
}
