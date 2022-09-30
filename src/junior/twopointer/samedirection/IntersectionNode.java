package junior.twopointer.samedirection;

import junior.datamodel.ListNode;

/**
 *
 *
 * 380 · 两个链表的交叉
 *
 * https://www.lintcode.com/problem/380/
 *
 * 描述
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 *
 * 如果两个链表没有交叉，返回null。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 说明
 * 样例
 * 样例 1：
 *
 * 输入：
 * 	A:          a1 → a2
 * 	                   ↘
 * 	                     c1 → c2 → c3
 * 	                   ↗
 * 	B:     b1 → b2 → b3
 * 输出：c1
 * 解释：在节点 c1 开始交叉。
 * 样例 2:
 *
 * 输入:
 * Intersected at 6
 * 1->2->3->4->5->6->7->8->9->10->11->12->13->null
 * 6->7->8->9->10->11->12->13->null
 * 输出: Intersected at 6
 * 解释：begin to intersect at node 6.
 * 挑战
 * 需满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode {

    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB){
            return null;
        }

        ListNode nodeA = headA;
        while (nodeA.next != null){
            nodeA = nodeA.next;
        }
        nodeA.next = headB;

        ListNode slow = headA;
        ListNode fast = headA;

        boolean hasCircle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasCircle = true;
                break;
            }
        }

        if (!hasCircle){
            return null;
        }

        nodeA = headA;
        while (nodeA != slow){
            nodeA = nodeA.next;
            slow = slow.next;
        }
        return nodeA;
    }
}
