class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1000000007;
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long[] nf = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) {
                    nf[0] = (nf[0] + freq[j]) % MOD;
                    nf[1] = (nf[1] + freq[j]) % MOD;
                } else {
                    nf[j + 1] = (nf[j + 1] + freq[j]) % MOD;
                }
            }
            freq = nf;
        }
        long ansres = 0;
        for (long count : freq) {
            ansres = (ansres + count) % MOD;
        }
        return (int) ansres;
    }
}
