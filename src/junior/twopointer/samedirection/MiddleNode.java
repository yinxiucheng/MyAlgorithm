package junior.twopointer.samedirection;

import junior.datamodel.ListNode;

public class MiddleNode {

    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (null == head){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
