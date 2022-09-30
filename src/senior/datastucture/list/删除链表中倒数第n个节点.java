package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/174/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 */
public class 删除链表中倒数第n个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;

        while (node != null){
            count ++;
            node = node.next;
        }
        if (count < n){
            return dummy.next;
        }

        ListNode pre = dummy;
        node = head;
        while (node != null){
            if (count == n){
                pre.next = node.next;
                node.next = null;
                return dummy.next;
            }
            count--;
            pre = node;
            node = node.next;
        }
        return dummy.next;
    }
}
