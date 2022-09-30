package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 *
 * https://www.lintcode.com/problem/36/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 * 链表 = 1->2->3->4->5->NULL
 * m = 2
 * n = 4
 *
 * 1->4->3->2->5->NULL
 */
public class 翻转链表2 {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = node;
        }
        reverseBetween(dummy.next, 1, 4);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head){
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode node = head;
        pre.next = node;

        ListNode tail1 = null;
        ListNode headList1 = null;

        ListNode tail2 = null;
        ListNode headList2 = null;

        int count = 0;
        while (node != null ){
            count ++;
            if (count == m){
                tail1 = pre;
                headList1 = node;
            }
            if (count == n){
                tail2 = node;
                headList2 = node.next;
            }
            pre = node;
            node = node.next;
        }

        tail2.next = null;
        ListNode newHeadList = reverse(headList1);
        ListNode newTail = findTail(newHeadList);
        newTail.next = headList2;
        if (tail1.next == head){
            return newHeadList;
        }
        tail1.next = newHeadList;
        return head;
    }

    private static ListNode findTail(ListNode head){
        ListNode pre = new ListNode(-1);
        ListNode node = head;
        pre.next = node;
        while (node != null){
            pre = node;
            node = node.next;
        }
        return pre;
    }

    private static ListNode reverse(ListNode head) {
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
