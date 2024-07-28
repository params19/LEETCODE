import java.util.*;

class Solution {
    public int nonSpecialCount(long lowerBound, long upperBound) {
        int maxLimit = (int) Math.sqrt(upperBound) + 1;
        boolean[] primeFlags = generateSieve(maxLimit);
        int rangeCount = (int) (upperBound - lowerBound + 1);
        int specialNumbersCount = 0;
        
        for (int num = 2; num <= maxLimit; num++) {
            if (primeFlags[num]) {
                long specialNum = (long) num * num;
                if (specialNum >= lowerBound && specialNum <= upperBound) {
                    specialNumbersCount++;
                }
            }
        }
        return rangeCount - specialNumbersCount;
    }

    private boolean[] generateSieve(int limit) {
        boolean[] primeFlags = new boolean[limit + 1];
        Arrays.fill(primeFlags, true);
        primeFlags[0] = primeFlags[1] = false;
        
        for (int num = 2; num * num <= limit; num++) {
            if (primeFlags[num]) {
                for (int multiple = num * num; multiple <= limit; multiple += num) {
                    primeFlags[multiple] = false;
                }
            }
        }
        
        return primeFlags;
    }
}
