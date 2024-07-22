import java.util.*;
class Solution {
    private void finalcomb(int ind,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<candidates.length;i++)
        {
            if(i>ind && candidates[i] == candidates[i-1])
            //here i>ind is used bcz we dont want to consider the same element again
            //and candidates[i] == candidates[i-1] is used to avoid duplicates
            {
                continue;
            }
            if(candidates[i] > target)
            {
                break;
            }
            ds.add(candidates[i]);
            finalcomb(i+1,candidates,target-candidates[i],ans,ds);
            //i+1 is used bcz we dont want to consider the same element again
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        finalcomb(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}