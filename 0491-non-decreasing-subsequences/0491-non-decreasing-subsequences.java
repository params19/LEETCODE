import java.util.*;
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int start, int[] nums)
    {
        if(tempList.size() >= 2)
        {
            res.add(new ArrayList<>(tempList));
        }
        Set<Integer> used = new HashSet<>();
        for(int i = start; i < nums.length; i++)
        {
            if(used.contains(nums[i])) continue;
            if(tempList.size() == 0 || nums[i] >= tempList.get(tempList.size() - 1))
            {
                used.add(nums[i]);
                tempList.add(nums[i]);
                backtrack(res, tempList, i + 1, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
