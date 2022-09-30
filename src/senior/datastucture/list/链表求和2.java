package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 链表求和2 {

    public ListNode addLists2(ListNode l1, ListNode l2) {
        ListNode ll1 = reverse(l1);
        ListNode ll2 = reverse(l2);
        return reverse(addLists(ll1, ll2));
    }

    private ListNode reverse(ListNode head){
       ListNode pre = null;
       while (head != null){
           ListNode temp = head.next;
           head.next = pre;
           pre = head;
           head = temp;
       }
       return pre;
    }

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
