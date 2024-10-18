class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // Set<Integer> set=new HashSet<>();
        // int n=nums.length;
        // for(int i : nums)
        //     set.add(i);
        // if(set.size()==1)return (int)Math.pow(2,n)-1;
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num; 
        }

        int count = 0;
        int n = nums.length;

        for (int i = 1; i < (1 << n); i++) {
            int currentOR = 0;
            for (int j = 0; j < n; j++) {
                
                if ((i & (1 << j)) != 0) {
                    currentOR |= nums[j]; 
                }
            }
            
            if (currentOR == maxOR) {
                count++;
            }
        }

        return count; 
    }
}