package senior.datastucture.list;

import junior.datamodel.ListNode;

public class 两数相乘 {

    public long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here
        long num1 = getNumFromList(l1);
        long num2 = getNumFromList(l2);
        return num1 * num2;
    }

    private long getNumFromList(ListNode head){
        long ans = 0;
        ListNode node = head;
        long wight = 1;
        while (node != null){
            wight *= 10;
            node = node.next;
        }

        node = head;
        while (node != null){
            ans += wight * node.val;
            wight = wight/10;
            node = node.next;
        }
        return ans;
    }
}
