package junior.datastructure;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/380/solution/16977?fromId=161&_from=collection
 *
 * 描述
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 */
public class GetIntersectionNode {

    public static void main(String[] args) {

        ListNode c13 = new ListNode(13);
        ListNode c12 = new ListNode(12, c13);
        ListNode c11 = new ListNode(11, c12);
        ListNode c10 = new ListNode(10, c11);

        ListNode a4 = new ListNode(9, c10);
        ListNode a3 = new ListNode(7, a4);
        ListNode a2 = new ListNode(5, a3);
        ListNode a1 = new ListNode(3, a2);

        ListNode a3_1 = new ListNode(17, a1);
        ListNode a2_1 = new ListNode(15, a3_1);
        ListNode a3_2 = new ListNode(27, a2_1);
        ListNode a2_2 = new ListNode(25, a3_2);
        ListNode headA = new ListNode(1, a2_2);

        ListNode b3 = new ListNode(8, c10);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(4, b2);
        ListNode headB = new ListNode(2, b1);

        ListNode intersectNode = getIntersectionNode(headA, headB);

    }
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB){
            return null;
        }
        ListNode pA = headA;
        while (pA.next != null){
            pA = pA.next;
        }
        pA.next = headB;

        ListNode intersectNode = isCircleListNode(headA);
        return intersectNode;
    }

    private static ListNode isCircleListNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        fast = fast.next;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
