package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 *
 * 1609 · 链表的中间结点
 */
public class 链表的中间节点 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null){
            return slow.next;
        }
        return slow;
    }

}
