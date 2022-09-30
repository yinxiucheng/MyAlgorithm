package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 删除链表中倒数第n个节点2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preDelete = head;

        for (int i = 0; i < n; i++) {
            if (head == null){
                return null;
            }
            head = head.next;
        }
        while (head != null){
            head = head.next;
            preDelete = preDelete.next;
        }

        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
