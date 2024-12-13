class Solution {
    public long shiftDistance(String s, String t, int[] nxt, int[] pre) {
        long cost = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            int si = s.charAt(i) - 'a';
            int ti = t.charAt(i) - 'a';
            int nxt_ch = si;
            long clw = 0;
            while (nxt_ch != ti) 
            {
                clw += nxt[nxt_ch];
                nxt_ch = (nxt_ch + 1) % 26;
            }
            
            int pre_ch = si;
            long anti = 0;
            while (pre_ch != ti)
            {
                anti += pre[pre_ch];
                pre_ch = (26 + pre_ch - 1) % 26;
            }
            cost += Math.min(anti, clw);
        }
        return cost;
    }
}
