public class PartionList {
    class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(-1);
        ListNode temp = head;
        ListNode tempA = a;
        ListNode tempB = b;

        while(temp!=null){
            if(temp.val<x){
                tempA.next=temp;
                tempA=tempA.next;
            }
            else {
                tempB.next=temp;
                tempB=tempB.next;
            }
            temp=temp.next;
        }
        tempB.next=null;
        a=a.next;
        b=b.next;
        if(a==null) return b;
        tempA.next=b;
        return a;
    }
}
}
