package junior.twopointer.merge;

import junior.datamodel.ListNode;

/**
 * 165 · 合并两个排序链表
 *
 * https://www.lintcode.com/problem/165/?fromId=161&_from=collection
 *
 * 样例 1:
 * 	输入: list1 = null, list2 = 0->3->3->null
 * 	输出: 0->3->3->null
 *
 *
 * 样例2:
 * 	输入:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * 	输出: 1->2->3->8->11->15->null
 */
public class MergeTwoLists {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            return mergeTwoListsInner(l1, l2);
        }else {
            return mergeTwoListsInner(l2, l1);
        }

    }

    private ListNode mergeTwoListsInner(ListNode l1, ListNode l2){
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        ListNode l1Pre = listNode1;

        while (listNode1 != null && listNode2 != null){
            while (listNode1.next != null && listNode1.val < listNode2.val){
                l1Pre = listNode1;
                listNode1 = listNode1.next;
            }
            ListNode node = listNode2;
            listNode2 = listNode2.next;
            node.next = listNode1;
            l1Pre.next = node;
            l1Pre = l1Pre.next;
        }

        if (listNode1 == null && listNode2 != null){
            l1Pre.next = listNode2;
        }

        return l1;
    }
}
