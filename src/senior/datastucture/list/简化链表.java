package senior.datastucture.list;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/294/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 */
public class 简化链表 {

    public ListNode simplify(ListNode head) {
        // write your code here
        int count = 0;
        ListNode curNode = head;
        ListNode tail = head;
        while (curNode != null){
            count++;
            tail = curNode;
            curNode = curNode.next;
        }

        if (count <= 2){
            return head;
        }
        String countStr = String.valueOf(count - 2);
        char[] chars = countStr.toCharArray();
        ListNode pre = head;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            pre.next = new ListNode(c);
            pre = pre.next;
        }
        pre.next = tail;
        return head;
    }
}
