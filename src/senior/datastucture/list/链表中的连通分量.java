package senior.datastucture.list;

import java.util.HashSet;
import java.util.Set;

public class 链表中的连通分量 {

    public int blockNumber(DoublyListNode head, int[] nodes) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int item : nodes) {
            set.add(item);
        }
        DoublyListNode node = head;
        int ans = 0;
        while (node != null){
            if (set.contains(node.val) && (node.next == null || !set.contains(node.next.val))){
                ans++;
            }
            node = node.next;
        }

        return ans;
    }

    class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }
}
