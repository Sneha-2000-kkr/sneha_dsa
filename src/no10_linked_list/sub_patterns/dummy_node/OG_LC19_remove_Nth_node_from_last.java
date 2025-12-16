package no10_linked_list.sub_patterns.dummy_node;
import no10_linked_list.sub_patterns.ListNode;

public class OG_LC19_remove_Nth_node_from_last {

    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int idx = len - n;
        if (idx == 0) return head.next;

        curr = head;
        for (int i = 1; i < idx; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public ListNode removeNthFromEndBetterApproach(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        OG_LC19_remove_Nth_node_from_last obj = new OG_LC19_remove_Nth_node_from_last();
        // head = [1,2,3,4,5]
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        ListNode n5= new ListNode(5);
        ListNode n6= new ListNode(6);

        // link nodes: 1->2->3->4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = n1;
        int n =2;

//        System.out.print("Brute force: ");
//        ListNode bruteResult = obj.removeNthFromEndBetterApproach(head,n);
//        ListNode.printList(bruteResult);

        System.out.print("Better Sol: ");
        ListNode optimisedResult = obj.removeNthFromEndBetterApproach(head,n);
        ListNode.printList(optimisedResult);





    }
}
