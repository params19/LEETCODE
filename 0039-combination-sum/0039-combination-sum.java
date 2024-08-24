import java.util.*;
class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        solve(0,candidates,target,res,temp);
        return res;
    }
    public void solve(int i,int[] candidates,int target,List<List<Integer>> res,List<Integer> temp){
        if(i==candidates.length)
        {
            if(target == 0)
            {
                 res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(candidates[i] <= target)
        {
            temp.add(candidates[i]);
            solve(i,candidates,target-candidates[i],res,temp);
            temp.remove(temp.size()-1);
        }
        // temp.remove(temp.size()-1);
        solve(i+1,candidates,target,res,temp);
    }
}