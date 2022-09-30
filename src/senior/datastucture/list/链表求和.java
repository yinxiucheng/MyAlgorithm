package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/167
 */
public class 链表求和 {

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode pre1 = l1;
        ListNode pre2 = l2;
        int carry = 0;
        ListNode point = dummy;

        while (pre1 != null && pre2 != null) {
            int sum = pre1.val + pre2.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            pre1 = pre1.next;
            pre2 = pre2.next;
            point = point.next;
        }

        while (pre1 != null){
            int sum = pre1.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            pre1 = pre1.next;
            point = point.next;
        }

        while (pre2 != null){
            int sum = pre2.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            pre2 = pre2.next;
            point = point.next;
        }

        if (carry != 0){
            point.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
