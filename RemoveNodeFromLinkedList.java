import java.util.Stack;

public class RemoveNodeFromLinkedList {
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

    public static  ListNode removeNodes(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {
            // Remove all smaller elements from stack
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        // Reconstruct list from stack
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        ListNode result = removeNodes(head);

        printList(result);
        
    }
}
