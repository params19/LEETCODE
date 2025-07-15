/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        if(h1==null|h2==null)return null;
        ListNode temp1=h1;
        ListNode temp2=h2;
        while(temp1!=temp2)
        {
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1==temp2)return temp1;
            if(temp1==null)temp1=h2;
            if(temp2==null)temp2=h1;
        }
        return temp1;
    }
}