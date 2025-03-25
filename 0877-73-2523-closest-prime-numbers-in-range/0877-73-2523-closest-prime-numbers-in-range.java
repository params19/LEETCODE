class Solution {
        private boolean[] sieve(int r) 
        {
        boolean[] isPrime= new boolean[r+1];
        Arrays.fill(isPrime, true);
        isPrime[0]= false;
        isPrime[1]= false;
        for (int i=2; i*i<=r; i++) {
            if (isPrime[i]) {
                for (int j=2; i*j<=r; j++) {
                    isPrime[i * j]=false;
                }
            }
        }
        return isPrime;
    }
    public int[] closestPrimes(int left, int right) 
    {
        boolean[] isPrime= sieve(right);
        List<Integer> primes= new ArrayList<>();
        for (int num=left; num<=right; num++) 
        {
            if (isPrime[num])primes.add(num);
        }
        int mdiff= Integer.MAX_VALUE;
        int[] res= {-1, -1};
        for (int i=1;i<primes.size();i++) 
        {
            int diff= primes.get(i)-primes.get(i - 1);
            if (diff< mdiff) {
                mdiff= diff;
                res[0]= primes.get(i-1);
                res[1]= primes.get(i);
            }
        }
        return res;
    }
}