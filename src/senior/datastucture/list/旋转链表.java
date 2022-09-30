package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/170/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 * 描述
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 *
 * 输入：1->2->3->4->5  k = 2
 * 输出：4->5->1->2->3
 *
 */
public class 旋转链表 {

    public static void main(String[] args) {
        int[] test = {17,75,80,87,44,45,75,86,74,20};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = node;
        }
        rotateRight(dummy.next, 19);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head){
            return null;
        }
        int count = getListNodeSize(head);
        if (k > count){
            k = k % count;
        }
        if (k == 0){
            return head;
        }
        ListNode kPre = findKPre(head, k);
        if (kPre == null){
            return head;
        }
        ListNode first = kPre.next;
        ListNode newHead = first;
        ListNode tail = kPre;
        while (first != null){
            tail = first;
            first = first.next;
        }
        tail.next = head;
        kPre.next = null;
        return newHead;
    }

    private static int getListNodeSize(ListNode head){
        ListNode node = head;
        int count = 0;
        while (node != null){
            count ++;
            node = node.next;
        }
        return count;
    }

    private static ListNode findKPre(ListNode head, int k){
        ListNode dummy = new ListNode(-1);
        ListNode preK = dummy;
        dummy.next = head;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null){
                return null;
            }
            node = node.next;
        }
        if (node == null){
            return null;
        }
        while (node != null){
            node = node.next;
            preK = preK.next;
        }
        return preK;
    }
}
