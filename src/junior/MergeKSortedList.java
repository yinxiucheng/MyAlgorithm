package junior;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (null == lists || lists.size() == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node: lists) {
            if (node != null){
                queue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null){
                queue.offer(node.next);
            }
        }
        return head;
        // write your code here
    }
}
