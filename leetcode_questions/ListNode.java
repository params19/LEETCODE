
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode current=head.next;
        while(current!=null)
        {
            if(current.val==0)
            {
                
            }
    }
}
}