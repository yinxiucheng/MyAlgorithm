package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/173/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 * 173 · 链表插入排序
 *
 */
public class 链表插入排序 {

    public static void main(String[] args) {
        int[] test = {1,3, 2, 0};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = node;
        }

        insertionSortList(dummy.next);

    }

    public static ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        while (head != null){
            insert(dummy, head.val);
            head = head.next;
        }
        return dummy.next;
    }

    private static void insert(ListNode dummy, int val){
        ListNode curNode = dummy.next;
        ListNode pre = dummy;
        while (curNode != null){
            if (val <= curNode.val){
                ListNode node = new ListNode(val);
                node.next = pre.next;
                pre.next = node;
                return;
            }
            pre = curNode;
            curNode = curNode.next;
        }
        ListNode node = new ListNode(val);
        pre.next = node;
        node.next = null;
    }
}
