public class PartitionList {

    // Definition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode aHead = new ListNode(-1); // smaller list dummy head
        ListNode bHead = new ListNode(-1); // greater or equal list dummy head
        ListNode a = aHead, b = bHead;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                a.next = temp;
                a = a.next;
            } else {
                b.next = temp;
                b = b.next;
            }
            temp = temp.next;
        }

        b.next = null; // important to avoid cycle
        a.next = bHead.next; // connect smaller + larger parts

        return aHead.next;
    }

    // Helper function to print linked list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();

        // create list: 1 → 4 → 3 → 2 → 5 → 2
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(4);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(2);
        head.next.next.next.next = obj.new ListNode(5);
        head.next.next.next.next.next = obj.new ListNode(2);

        int x = 3;
        ListNode ans = obj.partition(head, x);

        System.out.print("THE PARTITIONED LIST IS: ");
        obj.printList(ans);
    }
}
