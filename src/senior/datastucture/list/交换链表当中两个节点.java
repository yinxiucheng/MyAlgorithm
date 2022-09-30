package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 *
 */
public class 交换链表当中两个节点 {

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode curNode = head;
        ListNode pre1 = null;
        ListNode pre2 = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temPreNode = dummy;
        while (curNode != null){
            if (curNode.val == v1){
                pre1 = temPreNode;
            }
            if (curNode.val == v2){
                pre2 = temPreNode;
            }
            temPreNode = curNode;
            curNode = curNode.next;
        }

        if (pre1 != null && pre2 != null){
            if (pre1.next == pre2 || pre2.next == pre1){
                if (pre1.next == pre2){
                    ListNode node1 = pre1.next;
                    ListNode node2 = pre2.next;
                    ListNode temp = node2.next;
                    node2.next = node1;
                    pre1.next = node2;
                    node1.next = temp;
                    return dummy.next;
                }

                if (pre2.next == pre1){
                    ListNode node2 = pre2.next;
                    ListNode node1 = pre1.next;
                    ListNode temp = node1.next;
                    node1.next = node2;
                    pre2.next = node1;
                    node2.next = temp;
                    return dummy.next;
                }
            }
            ListNode node1 = pre1.next;
            ListNode node2 = pre2.next;
            ListNode tem = node1.next;
            node1.next = node2.next;
            node2.next = tem;
            pre1.next = node2;
            pre2.next = node1;
        }
        return dummy.next;
    }
}
