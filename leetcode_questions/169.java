import java.util.*;
class Solution {
    // TIME COMPLEXITY : O(nlogn)
    // SPACE COMPLEXITY : O(1)
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n/2];
    }
}