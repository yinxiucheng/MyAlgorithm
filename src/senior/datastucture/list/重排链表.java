package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 重排链表 {

    public void reorderList(ListNode head) {
        if (null == head || head.next == null){
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        if (null == head){
            return null;
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

    private void merge(ListNode head1, ListNode head2){
        ListNode node1 = head1;
        ListNode node2 = head2;
        ListNode pre = node1;
        while (node1 != null && node2 != null){
            ListNode temp1 = node1.next;
            ListNode temp2 = node2.next;
            node1.next = node2;
            node2.next = temp1;
            pre = node2;
            node1 = temp1;
            node2 = temp2;
        }

        if (node2 != null){
            pre.next = node2;
        }
    }
}
