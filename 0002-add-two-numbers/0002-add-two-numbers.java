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

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0); // making a new node result with node value initally 0
        ListNode ptr = result;// ptr pointing on node result

        int carry =0;// set default carry

        while(l1!=null && l2!=null){
            int sum= 0+carry;

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            carry=sum/10;
            sum=sum%10;
            // suppose you add 9+8, 17, your sum will be 7 and carry 1.
            ptr.next=new ListNode(sum);
            ptr=ptr.next;

        }

        if(carry == 1)ptr.next = new ListNode(1);
        return result.next;
    }
}
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry+0;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        return result.next;
    }
}