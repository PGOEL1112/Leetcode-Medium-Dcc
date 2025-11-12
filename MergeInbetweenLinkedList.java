public class MergeInbetweenLinkedList {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static  ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        for (int i =1; i<a ; i++) {
            temp1 = temp1.next;
        }

        ListNode temp2 = list1;
        for (int i = 0 ; i<b; i++) {
            temp2 = temp2.next;
        }

        if(temp2.next!=null) temp2 = temp2.next;

        temp1.next = list2;
        while(temp1.next!=null){
            temp1 = temp1.next;
        }

        temp1.next = temp2;
        return  list1;
    }

    public static void printlist(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(head.val + " -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);


        ListNode head2 = new ListNode(1000000);
        head2.next = new ListNode(1000001);
        head2.next.next = new ListNode(1000002);
        head2.next.next.next = new ListNode(1000003);
        head2.next.next.next.next = new ListNode(1000004);

        int a = 3;
        int b = 4;
        ListNode result = mergeInBetween(head,a,b,head2);
        printlist(result);
    }
}
