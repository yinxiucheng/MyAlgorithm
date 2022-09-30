package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 链表转数组 {

    public List<Integer> toArrayList(ListNode head) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            result.add(node.val);
            node = node.next;
        }
        return result;
    }
}
