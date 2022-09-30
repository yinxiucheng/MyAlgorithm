package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 链表组件 {

    public int numComponents(ListNode head, int[] g) {
       Set<Integer> set = new HashSet<>();
        for (Integer item: g) {
            set.add(item);
        }
        ListNode node = head;
        int ans = 0;
        while (node != null){
            if (set.contains(node.val) && (node.next == null || !set.contains(node.next.val))){
                ans ++;
            }

            node = node.next;
        }

        return ans;
    }
}
