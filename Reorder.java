public class Reorder {
    class Solution {
    public ListNode middleNode(ListNode  head){
        ListNode  slow=head;
        ListNode  fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode  current = head;
        ListNode  prev=null;
        ListNode  Next=head;
        while(current!=null) {
            Next=current.next;
            current.next=prev;
            prev=current;
            current=Next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode LeftMiddle = middleNode(head);
        ListNode head2 = LeftMiddle.next;
        LeftMiddle.next=null;
        head2=reverseList(head2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null && head2!=null){
            temp.next=head;
            head=head.next;
            temp=temp.next;

            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        if(head==null) temp.next=head2;
        if(head2==null) temp.next=head;
        head=dummy.next;
        
    }
}
}
