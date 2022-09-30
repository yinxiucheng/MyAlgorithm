package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/98/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 * 在 O(nlogn) 时间复杂度和常数级的空间复杂度下给链表排序。
 */
public class 链表排序2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(2);
        sortList(head);

    }

    // 快排链表。
    public static ListNode sortList(ListNode head) {
        if (null == head || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);

        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1), dummy3 = new ListNode(-1);
        ListNode tailLeft = dummy1, tailMid = dummy2, tailRight = dummy3;
        ListNode node = head;

        //partition
        while (node != null){
            if (node.val > mid.val){
                tailRight.next = node;
                tailRight = tailRight.next;
            }else if (node.val < mid.val){
                tailLeft.next = node;
                tailLeft = tailLeft.next;
            }else {
                tailMid.next = node;
                tailMid = tailMid.next;
            }
            node = node.next;
        }

        tailLeft.next = null;
        tailMid.next = null;
        tailRight.next = null;

        ListNode headLeft = sortList(dummy1.next);
        ListNode headRight = sortList(dummy3.next);

        return connected(headLeft, dummy2.next, headRight);
    }

    private static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode connected(ListNode left, ListNode mid, ListNode right){
        ListNode dummy = new ListNode(-1, left);
        ListNode cur = left;
        ListNode pre = dummy;
        while (cur != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = mid;
        cur = pre.next;
        while (cur != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = right;
        return dummy.next;
    }

}
