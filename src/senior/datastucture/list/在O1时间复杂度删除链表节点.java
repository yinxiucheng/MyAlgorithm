package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 在O1时间复杂度删除链表节点 {

    public void deleteNode(ListNode node) {
       if (node == null) return;
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
