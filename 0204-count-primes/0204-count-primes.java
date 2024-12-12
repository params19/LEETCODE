class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        return sieve(n);
    }

    private static int sieve(int n) {
        boolean[] is_prime = new boolean[n];
        Arrays.fill(is_prime, true);
        is_prime[0] = false; 
        is_prime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (is_prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (is_prime[i])count++;
        }
        return count;
    }
}
