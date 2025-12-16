package no10_linked_list.sub_patterns.reverse;
import java.util.ArrayList;
import no10_linked_list.sub_patterns.ListNode;

public class OG_LC206_reverse_linked_list {

    public ListNode reverseListBruteForce(ListNode head) {
        if (head == null) return null;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            curr.val = list.get(i);
            curr = curr.next;
        }
        return head;
    }

    public ListNode reverseListOptimisedSol(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }



    public static void main(String[] args) {
        OG_LC206_reverse_linked_list obj = new OG_LC206_reverse_linked_list();

        // head = [1,2,3,4,5]
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);

        // link nodes: 1->2->3->4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        // head
        ListNode head = n1;

        System.out.print("Original List: ");
        ListNode.printList(n1);

        // Brute force reverse (value based)
        ListNode bruteResult = obj.reverseListBruteForce(n1);
        System.out.print("Brute force: ");
        ListNode.printList(bruteResult);

        // recreate list again (important!)
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        // Optimised reverse (pointer based)
        ListNode optResult = obj.reverseListOptimisedSol(m1);
        System.out.print("Optimised Sol: ");
        ListNode.printList(optResult);




    }
}
