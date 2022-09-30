package junior;

public class ListNode implements Comparable<ListNode>{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    @Override
    public int compareTo(ListNode o) {
        return val - o.val;
    }
}
