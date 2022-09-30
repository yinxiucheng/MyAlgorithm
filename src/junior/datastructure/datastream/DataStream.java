package junior.datastructure.datastream;

import junior.datamodel.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataStream {
    HashSet<Integer> duplicate = new HashSet<>();
    Map<Integer, ListNode> valToPreNode = new HashMap<>();
    ListNode dummy, tail;

    public DataStream(){
        dummy = new ListNode(0);
        tail = dummy;
    }

    public void pushBack(int val){
        ListNode node = new ListNode(val);
        tail.next = node;
        valToPreNode.put(val, tail);
        tail = node;
    }

    public void remove(int val){
        ListNode preNode = valToPreNode.get(val);
        valToPreNode.remove(val);
        ListNode deleteNode = preNode.next;
        ListNode nextNode = deleteNode.next;
        preNode.next = nextNode;
        if (nextNode != null) {
            valToPreNode.put(nextNode.val, preNode);
        } else {
            tail = preNode;
        }
    }

    public void add(int val){
        if (duplicate.contains(val)) {
            return;
        }

        if (!valToPreNode.containsKey(val)){
            pushBack(val);
            return;
        }
        duplicate.add(val);
        remove(val);
    }

    public int firstUnique(){
        if (dummy.next != null){
            return dummy.next.val;
        }
        return -1;
    }

}
