package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 链表的反向带权和 {

    public int weightedSumReverse(ListNode head) {
        int ans = 0;
        ListNode node = head;
        int count = 0;
        while (node != null){
            count ++;
            node = node.next;
        }
        node = head;
        while (node !=  null){
            ans += count-- * node.val;
            node = node.next;
        }
        return ans;
    }
}
