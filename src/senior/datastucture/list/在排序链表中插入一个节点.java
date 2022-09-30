package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * 在链表中插入一个节点。
 */
public class 在排序链表中插入一个节点 {

    public ListNode insertNode(ListNode head, int val) {
        if (null == head){
            return new ListNode(val);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = head;

        if (val < node.val){
            ListNode addPoint = new ListNode(val);
            addPoint.next = head;
            return addPoint;
        }

        while (node != null){
            pre = node;
            node = node.next;
            if (node != null){
                if (val <= node.val){
                    ListNode addPoint = new ListNode(val);
                    pre.next = addPoint;
                    addPoint.next = node;
                    return dummy.next;
                }
            }
        }

        if (val > pre.val){
            pre.next = new ListNode(val);
        }

        return dummy.next;
    }
}
