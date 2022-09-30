package junior.twopointer.samedirection;

import junior.datamodel.ListNode;

/**
 * 102 · 带环链表
 *
 * https://www.lintcode.com/problem/102/
 * 描述
 * 给定一个链表，判断它是否有环。
 *
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
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
        // write your code here
    }
}
