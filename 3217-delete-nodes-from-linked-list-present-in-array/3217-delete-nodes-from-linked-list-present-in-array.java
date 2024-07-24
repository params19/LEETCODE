/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        ListNode du = new ListNode(0);
        du.next = head;
        ListNode current = du;
        while (current.next != null) {
            if (s.contains(current.next.val)) {
               
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return du.next;
    }
    
}