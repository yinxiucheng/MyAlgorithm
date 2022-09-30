package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/98/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 * 在 O(nlogn)O(nlogn) 时间复杂度和常数级的空间复杂度下给链表排序。
 *
 * 归并排序：
 *
 */
public class 链表排序 {

    public ListNode sortList(ListNode head) {
        if (null == head || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            }else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }

        if (head1 != null){
            tail.next = head1;
        }

        if (head2 != null){
            tail.next = head2;
        }
        return dummy.next;
    }

}
