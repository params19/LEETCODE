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
    public int[] nextLargerNodes(ListNode head) {
        int n=0;
        ListNode temp=head;
        ListNode last;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        last=reverse(head);
        int res[]=new int[n];
        Stack<Integer> ss=new Stack<>();
        int i=0;
        while(last!=null)
        {
            while(!ss.isEmpty()&&last.val>=ss.peek())
            {
                ss.pop();
            }
            if(ss.isEmpty())res[i]=0;
            else{
                res[i]=ss.peek();
            }
            i++;
            ss.push(last.val);
            last=last.next;
        }
        for(int j=0;j<n/2;j++)
        {
            int tem=res[j];
            res[j]=res[n-j-1];
            res[n-j-1]=tem;
        }
        return res;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}