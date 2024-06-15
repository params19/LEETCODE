import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> ll = new HashSet<>();
        for (int num : nums) 
        {
            if (num > 0) 
            {
                ll.add(num);
            }
        }
        int missing = 1;
        for (int num : ll)
        {
            if (num != missing)
            {
                return missing;
            }
            missing++;
        }
        return ll.size() + 1;
    }
}
