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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null||k==0)return head;
        ListNode temp=head;
        int size=1;
        while(temp.next!=null)
        {
            size++;
            temp=temp.next;
        }
        k=k%size;
        if(k==0)return head;
        temp.next=head;
        int pos=size-k;
        ListNode end=head;
        while(--pos>0)
        {
            end=end.next;
        }
        ListNode start=end.next;
        end.next=null;
        return start;
    }
}