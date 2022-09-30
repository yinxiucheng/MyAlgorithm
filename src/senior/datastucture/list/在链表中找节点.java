package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 在链表中找节点 {

    public ListNode findNode(ListNode head, int val) {
        // write your code here
        ListNode node = head;
        while (node != null){
            if (node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
