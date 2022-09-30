package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 翻转链表 {

    public ListNode reverse(ListNode head) {
        if (null == head){
            return  null;
        }
        ListNode pre = new ListNode(-1);
        ListNode node = head;
        pre.next = node;
        while (node != null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        head.next = null;
        return pre;
    }
}
