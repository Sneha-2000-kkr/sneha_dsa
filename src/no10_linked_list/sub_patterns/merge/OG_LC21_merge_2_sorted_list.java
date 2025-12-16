package no10_linked_list.sub_patterns.merge;
import no10_linked_list.sub_patterns.ListNode;

public class OG_LC21_merge_2_sorted_list {

    public ListNode mergeTwoListsBruteForce(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                curr.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            curr = curr.next;
        }

        while (p1 != null) {
            curr.next = new ListNode(p1.val);
            p1 = p1.next;
            curr = curr.next;
        }

        while (p2 != null) {
            curr.next = new ListNode(p2.val);
            p2 = p2.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode mergeTwoListsBetterApproach(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        OG_LC21_merge_2_sorted_list obj = new OG_LC21_merge_2_sorted_list();

        // list1 = [1,2,4]
        ListNode l1n1 = new ListNode(1);
        ListNode l1n2 = new ListNode(3);
        ListNode l1n3 = new ListNode(5);

        l1n1.next = l1n2;
        l1n2.next = l1n3;

        ListNode list1 = l1n1;

// list2 = [1,3,4]
        ListNode l2n1 = new ListNode(2);
        ListNode l2n2 = new ListNode(4);
        ListNode l2n3 = new ListNode(6);

        l2n1.next = l2n2;
        l2n2.next = l2n3;

        ListNode list2 = l2n1;

// print to verify
        ListNode.printList(list1);
        ListNode.printList(list2);

        System.out.print("Brute force: ");
        ListNode bruteResult = obj.mergeTwoListsBruteForce(list1, list2);
        ListNode.printList(bruteResult);

    }
}
