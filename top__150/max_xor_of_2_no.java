package top__150;
import java.util.HashSet;
class Solution {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--)
        {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums)
            {
                set.add(num & mask);
            }
            int temp = max | (1 << i);
            for(int prefix : set)
            {
                if(set.contains(prefix ^ temp))
                {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
