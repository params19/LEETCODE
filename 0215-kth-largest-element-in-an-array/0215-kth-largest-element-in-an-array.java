class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Through Priority Queue 
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

       
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}