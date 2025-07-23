public class SwapNode {
    class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode tempo = odd;
        ListNode tempe = even;
        ListNode temp = head;
        while(temp!=null){
            tempo.next=temp;
            temp=temp.next;
            tempo=tempo.next;

            tempe.next=temp;
            if(temp==null) break;
            temp=temp.next;
            tempe=tempe.next;
        }
        odd=odd.next;
        even=even.next;
        tempo.next=null;

        ListNode merge= new ListNode(-1);
        ListNode tempm=merge;
        tempo=odd;
        tempe=even;

        while(tempo!=null && tempe!=null){
            tempm.next=tempe;
            tempe=tempe.next;
            tempm=tempm.next;

            tempm.next=tempo;
            tempo=tempo.next;
            tempm=tempm.next;
        }
        if(tempe==null) tempm.next=tempo;
        else tempm.next=tempe;
        return merge.next;  
    }
}
}
