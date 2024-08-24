import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);  // 
        solve(0, candidates, target, res, temp);
        return res;
    }

    private void solve(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));  
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue; 
            }
            if (candidates[i] > target) {
                break; 
            }
            temp.add(candidates[i]);
            solve(i + 1, candidates, target - candidates[i], res, temp); 
            temp.remove(temp.size() - 1);
        }
    }
}
