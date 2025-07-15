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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int cnt=0;
        while(cnt<k)
        {
            if(temp==null)return head;
            temp=temp.next;
            cnt++;
        }
        ListNode prev=reverseKGroup(temp, k);
        temp=head;
        cnt=0;
        while(cnt<k)
        {
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
            cnt++;
        }
        return prev;
    }
}