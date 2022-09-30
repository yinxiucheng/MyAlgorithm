package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/223/?showListFe=true&page=1&problemTypeId=2&tagIds=362&pageSize=50
 */
public class 回文链表 {

    public static void main(String[] args) {
        int[] test = {-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            pre.next = node;
            pre = pre.next;
        }
        boolean result = isPalindrome(dummy.next);
        System.out.println("the result is " + result);
    }

    public static boolean isPalindrome(ListNode head) {
        if (null == head){
            return true;
        }
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        if (list.size() == 1){
            return true;
        }

        boolean isPalindrome = true;
        for (int i = 0; i < list.size()/2 + 1; i++) {
            int j = list.size() - 1 - i;
            if (j >= i){
                int a = list.get(i);
                int b = list.get(j);
                if (a != b) {
                  isPalindrome = false;
                  break;
                }
            }else {
                break;
            }
        }
        return isPalindrome;
    }
}
