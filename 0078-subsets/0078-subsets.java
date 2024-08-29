// import java.util.*;
// class Solution {
//     public List<List<Integer>> result = new ArrayList<>(); 
//     public List<List<Integer>> subsets(int[] nums) {
//         List<Integer> temp = new ArrayList<>(); 
//         solve(nums, 0, temp); 
//         return result; 
//     }
//     private void solve(int[] nums, int idx, List<Integer> temp) {
//         if (idx >= nums.length)
//         { 
//             result.add(new ArrayList<>(temp)); 
//             return;
//         }
//         temp.add(nums[idx]);
//         solve(nums, idx + 1, temp);
//         temp.remove(temp.size() - 1);
//         solve(nums, idx + 1, temp);
//     }
// }
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for(int mask=0;mask<(1<<nums.length);mask++)
        {
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                if((mask&(1<<i))!=0)
                {
                    ll.add(nums[i]);
                }
            }
            res.add(ll);
        }
        return res;
    }
}