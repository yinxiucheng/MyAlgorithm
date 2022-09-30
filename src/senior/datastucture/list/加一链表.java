package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 加一链表 {

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        boolean successive = false;
        ListNode lastNineNode = null;
        ListNode pre = null;
        if (node.val == 9){
            successive = true;
            pre = dummy;
            lastNineNode = head;
        }

        while (node.next != null){
            ListNode preTemp = node;
            node = node.next;
            if (node.val != 9){
                successive = false;
                pre = null;
                lastNineNode = null;
            }else {
                if (!successive){
                    pre = preTemp;
                }
                lastNineNode = head;
                successive = true;
            }
        }

        if (lastNineNode == null){
            node.val ++;
            return dummy.next;
        }

        if (pre != dummy){
            pre.val ++;
            ListNode curNode = pre;
            while (curNode.next != null){
                curNode = curNode.next;
                curNode.val = 0;
            }
            return dummy.next;
        }

        if (pre == dummy){
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            dummy.next = newNode;
            ListNode curNode = newNode;
            while (curNode.next != null){
                curNode = curNode.next;
                curNode.val = 0;
            }
            return dummy.next;
        }

        return dummy.next;
    }
}
