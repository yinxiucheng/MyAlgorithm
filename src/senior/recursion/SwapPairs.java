package senior.recursion;

import junior.datamodel.ListNode;

/**
 * 451 · 两两交换链表中的节点
 * https://www.lintcode.com/problem/451/
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode suffix = swapPairs(second.next);
        second.next = first;
        first.next = suffix;

        return second;
    }


    public ListNode swapPairsIteration(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null){
            ListNode first = head.next;
            ListNode second = head.next.next;

            head.next = second;
            first.next = second.next;
            second.next = first;
            head = first;
        }
        return dummy.next;
    }


}
