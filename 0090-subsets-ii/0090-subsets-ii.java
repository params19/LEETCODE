class Solution {
     private List<List<Integer>> result = new ArrayList<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>(); 
        Arrays.sort(nums);
        solve(nums, 0, temp); // Start backtracking from index 0
        return result; // Return the final list of subsets
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {
        if (idx >= nums.length)
        { // Base case: if index is out of bounds
            if(!result.contains(new ArrayList<>(temp)))
            result.add(new ArrayList<>(temp)); // Add the current subset to the result list
            return;
        }

        // Include nums[idx] in the current subset and move to the next element
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);

        // Backtrack: remove the last element and explore the possibility of not including nums[idx]
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }
}