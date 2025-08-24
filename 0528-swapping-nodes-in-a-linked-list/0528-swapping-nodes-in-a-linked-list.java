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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        ListNode f=null;
        ListNode s=head;
        for(int i=1;i<k;i++)
        {
            curr=curr.next;
        }
        f=curr;
        while(curr.next!=null)
        {
            curr=curr.next;
            s=s.next;
        }
        Integer temp=f.val;
        f.val=s.val;
        s.val=temp;
        return head;
    }
}