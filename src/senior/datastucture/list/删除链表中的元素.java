package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * 452 · 删除链表中的元素
 */
public class 删除链表中的元素 {

    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode node = head;
        while (node != null){
            if (node.val == val){
               pre.next =  node.next;
               node = pre.next;
            }else {
                pre = node;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
