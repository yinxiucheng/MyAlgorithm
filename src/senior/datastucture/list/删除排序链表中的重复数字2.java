package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 113 · 删除排序链表中的重复数字（二）
 *
 * https://www.lintcode.com/problem/113/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 */
public class 删除排序链表中的重复数字2 {

    public static void main(String[] args) {

        int[] test = {0, 1, 1, 2, 3};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = node;
        }

        deleteDuplicates(dummy.next);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        boolean firstRepeat = false;
        ListNode preDelete = null;
        ListNode prePre = null;

        while (node != null) {
            if (set.contains(node.val)) {
                if (!firstRepeat) {
                    firstRepeat = true;
                    preDelete = prePre;
                }
            } else {
                if (firstRepeat) {
                    preDelete.next = node;
                    firstRepeat = false;
                    pre = preDelete;
                }
                set.add(node.val);
            }
            prePre = pre;
            pre = node;
            node = node.next;
        }
        if (firstRepeat) {
            preDelete.next = null;
        }
        return dummy.next;
    }
}
