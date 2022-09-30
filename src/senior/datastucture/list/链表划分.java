package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 链表划分 {

    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummy1 = new ListNode(-1);
        ListNode tail1 = dummy1;

        ListNode dummy2 = new ListNode(-1);
        ListNode tail2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                tail1.next = new ListNode(head.val);
                tail1 = tail1.next;
            } else {
                tail2.next = new ListNode(head.val);
                tail2 = tail2.next;
            }
            head = head.next;
        }

        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
