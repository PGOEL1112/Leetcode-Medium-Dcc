public class RotateList {
    class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        ListNode temp = head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }

        k%=n;
        if(k==0) return head;

        ListNode slow=head;
        ListNode fast=head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next;
        }

        ListNode newhead = slow.next;
        slow.next=null;
        fast.next=head;
        return newhead;

        
    }
}
}
