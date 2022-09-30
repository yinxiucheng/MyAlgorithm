package senior.datastucture.list;

import junior.datamodel.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 相反的顺序存储 {

    public List<Integer> reverseStore(ListNode head) {
        List<Integer> results = new ArrayList<>();

        ListNode curNode = head;
        while (curNode != null){
            results.add(results.size(), curNode.val);
            curNode = curNode.next;
        }

        return  results;
    }
}
