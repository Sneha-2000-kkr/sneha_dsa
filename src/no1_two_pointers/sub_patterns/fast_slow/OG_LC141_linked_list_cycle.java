package no1_two_pointers.sub_patterns.fast_slow;
import java.util.HashSet;

class ListNode {
      int val;
     ListNode next;
    ListNode(int x) {
        val = x;
         next = null;
     }

 }
public class OG_LC141_linked_list_cycle {

    // brute force way h, we are maintainning a hash set to see whether the node at head pointer was visited previously or not
    public boolean hasCycleBruteForce(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // slow & fath pointer technique
    public boolean hasCycleOptimised(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    public static void main(String[] args) {
        OG_LC141_linked_list_cycle obj = new OG_LC141_linked_list_cycle();
        // create nodes
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        // link nodes: 3 -> 2 -> 0 -> -4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // create cycle (pos = 1, means tail connects to node with value 2)
        n4.next = n2;

        // head
        ListNode head = n1;

        System.out.println("Brute Force Solution:  " + obj.hasCycleBruteForce(head));

        System.out.println("Optmised Solution: " + obj.hasCycleOptimised(head));



    }
}
