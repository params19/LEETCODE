import java.util.*;

class Solution {
    
    public int solve(int[] nums, int l, int r) {
        if (l > r)
            return 0;
        
        if (l == r)
            return nums[l];
        
        int take_left  = nums[l] + Math.min(solve(nums, l+2, r), solve(nums, l+1, r-1));
        int take_right = nums[r] + Math.min(solve(nums, l, r-2), solve(nums, l+1, r-1));
        
        return Math.max(take_left, take_right);
    }
    
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length; 
        
        int total = Arrays.stream(nums).sum(); // Calculate total sum of nums array
        
        int player1 = solve(nums, 0, n-1); // Calculate player1's score
        int player2 = total - player1; // Calculate player2's score
        
        return player1 >= player2; 
    }
}
