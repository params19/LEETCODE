import java.util.Map;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();
    
        for (int i = 0; i < k; i++) {
            remainderFreq.put(i, 0);
        }

        for (int num : arr) {
            int rem = ((num % k) + k) % k; 
            remainderFreq.put(rem, remainderFreq.get(rem) + 1);
        }

        if (remainderFreq.get(0) % 2 != 0) 
        {
            return false;
        }
        for (int rem = 1; rem <= k / 2; rem++) 
        {
            int counterHalf = k - rem;
            if (!remainderFreq.get(counterHalf).equals(remainderFreq.get(rem))) {
                return false;
            }
        }
        return true;
    }
}