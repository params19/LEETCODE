import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> f1 = new HashMap<>();
        for (int num : nums1) 
        {
            f1.put(num,f1.getOrDefault(num, 0) + 1);
        }
        List<Integer> inter= new ArrayList<>();
        for (int num : nums2) 
        {
            if (f1.containsKey(num) && f1.get(num) > 0) 
            {
                inter.add(num);
                f1.put(num, f1.get(num) - 1);
            }
        }
        int[] res = new int[inter.size()];
        for (int i = 0; i < inter.size(); i++)
        {
            res[i] = inter.get(i);
        }
        return res;
    }
}
