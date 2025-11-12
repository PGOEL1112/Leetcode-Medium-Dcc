public class SwappingNodesInLinkedList {
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

    public static ListNode findSwapNode(ListNode temp, int len){
        int length = 0;
        while(temp!=null){
            if(length==len)return temp;
            temp = temp.next;
            length++;
        }
        return temp;
    }

    public static int length(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp.next!=null){
            temp = temp.next;
            len++;
        }
        return len;
    }

    public static  ListNode swapNodes(ListNode head, int k) {
        int n = length(head);
        int count = 1;
        ListNode temp = head;
        ListNode tempNode = new ListNode(-1);
        while(temp!=null){
            if(count==k) {
                int len = n-k+1;
                ListNode temp2 = findSwapNode(head, len);

                // Swapping values of nodes
                tempNode.val = temp.val;
                temp.val = temp2.val;
                temp2.val = tempNode.val;
                break;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode temp = head;

        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode result = swapNodes(head,k);
        printList(result);

    }
}
