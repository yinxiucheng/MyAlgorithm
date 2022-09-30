package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/112/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 *
 */
public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (set.contains(node.val)){
                pre.next = node.next;
                node = pre.next;
                continue;
            }else {
                set.add(node.val);
            }
            pre = node;
            node = node.next;
        }
        return dummy.next;
    }
}
