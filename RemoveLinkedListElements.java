public class RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) { 
            this.val = val; 
        }
        
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to simplify head deletion
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        // Traverse the list
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next; // skip the node
            } else {
                temp = temp.next; // move forward
            }
        }

        return dummy.next; // new head of the list
    }

    public static void main(String[] args) {
        int val = 6;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = removeElements(head,val);
        printList(result);
    }
}
