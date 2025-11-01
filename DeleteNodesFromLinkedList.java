import java.util.HashSet;

public class DeleteNodesFromLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
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

    public static ListNode modifiedList(int[] nums, ListNode head){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode temp = result;

        while(temp.next!=null) {
            if(set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }  
        }
        return result.next;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        
        ListNode result = modifiedList(nums, head);

        printList(result);
    }
    
}
