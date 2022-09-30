package senior.datastucture.list;

import junior.datamodel.ListNode;
import junior.datamodel.TreeNode;

import java.util.List;

public class 链表化数组 {

    public ListNode toLinkedList(List<Integer> nums) {
        int n = nums.size();
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(nums.get(i));
            preNode.next = node;
            preNode = node;
        }

        return dummy.next;
    }
}
