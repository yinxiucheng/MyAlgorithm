package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 链表节点计数 {

    public int countNodes(ListNode head) {
        int count = 0;
        ListNode curNode = head;
        while (curNode != null){
            count++;
            curNode = curNode.next;
        }


        return count;
        // write your code here
    }
}
