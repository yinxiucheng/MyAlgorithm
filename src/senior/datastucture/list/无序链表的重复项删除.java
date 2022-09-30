package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 无序链表的重复项删除 {

    public static void main(String[] args) {
        int[] test = {1, 2, 1, 3, 3, 5, 6, 3};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = node;
        }
        removeDuplicates(dummy.next);
    }

    public static ListNode removeDuplicates(ListNode head) {

        if (null == head){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = head;
        while (node != null){
            if (set.contains(node.val)){
                pre.next = node.next;
                if (pre.next == null){
                    break;
                }else {
                    node = pre.next;
                    continue;
                }
            }else {
                set.add(node.val);
            }
            pre = node;
            node = node.next;
        }

        return dummy.next;
    }
}
