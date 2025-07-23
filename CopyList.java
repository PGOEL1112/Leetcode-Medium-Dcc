import org.w3c.dom.Node;
public class CopyList {
    class Solution {
    public Node deepcopy(Node head){
        Node head2 = new Node(head.val);
        Node t1=head.next;
        Node t2=head2;
        while(t1!=null){
            Node temp=new Node(t1.val);
            t2.next=temp;
            t2=t2.next;
            t1=t1.next;
        }
        return head2;
    }

    public void connectalternatively(Node head, Node head2){
        Node t1=head;
        Node t2=head2;
        Node dummy=new Node(1);
        Node t=dummy;
        while(t1!=null && t2!=null){
            t.next=t1;
            t1=t1.next;
            t=t.next;

            t.next=t2;
            t2=t2.next;
            t=t.next;
        }
    }


    public void split(Node head,Node head2){
        Node t1=head;
        Node t2=head2;
        while(t1!=null){
            t1.next=t2.next;
            t1=t1.next;
            if(t1==null) break;
            t2.next=t1.next;
            t2=t2.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // step-1 create deep copy
        Node head2=deepcopy(head);

        // step-2 joint head and head2 alternatively
        connectalternatively(head,head2);

        // step-3 assign random pointer
        Node t1=head;
        Node t2=head2;
        while(t1!=null){
            t2=t1.next;
            if(t1.random!=null){
                t2.random=t1.random.next;
            }
            t1=t1.next.next;
        }
        // step-4 split linked list
        split(head,head2);
        return head2;
        
    }
}
}
