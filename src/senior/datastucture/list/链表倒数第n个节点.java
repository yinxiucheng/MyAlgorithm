package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/166/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 */
public class 链表倒数第n个节点 {

    public ListNode nthToLast(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            if (head == null){
                return null;
            }
            head = head.next;
        }

        while (head != null){
            head = head.next;
            pre = pre.next;
        }

        return pre.next;
    }

}
