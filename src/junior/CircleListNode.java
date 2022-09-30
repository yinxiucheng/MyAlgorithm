package junior;

import junior.datamodel.ListNode;

public class CircleListNode {


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(5);
        head.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
        ListNode node5 = new ListNode(1);
        node4.next = node5;
        node5.next = node1;

        boolean hasCycle = hasCycle(head);
        System.out.println(" hasCycle: " + hasCycle);
    }
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
