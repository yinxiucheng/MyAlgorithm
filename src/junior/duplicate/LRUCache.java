package junior.duplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/134/?fromId=161&_from=collection
 *
 */

public class LRUCache {
    int capacity;
    ListNode dummy, tail;
    Map<Integer, ListNode> keyToPre;

    public LRUCache(int capacity){
        this.capacity = capacity;
        dummy = new ListNode(0,0, null);
        tail = dummy;
        keyToPre = new HashMap<>();
    }

    private void pushBack(ListNode node){
        tail.next = node;
        keyToPre.put(node.key, tail);
        tail = node;
    }

    private void popTop(){
        keyToPre.remove(dummy.next.key);
        ListNode node = dummy.next;
        dummy.next = node.next;
        keyToPre.put(node.next.key, dummy);
    }

    private void kick(ListNode preNode){
        ListNode node = preNode.next;
        if (node.next == null){
            return;
        }
        preNode.next = node.next;
        keyToPre.put(node.next.key, preNode);
        node.next = null;
        pushBack(node);
    }

    /**
     *  need return ListNode value
     * @param key
     * @return
     */
    public int get(int key){
        if (!keyToPre.containsKey(key)){
            return -1;
        }
        ListNode preNode = keyToPre.get(key);
        ListNode current = preNode.next;
        kick(preNode);
        return current.value;
    }

    public void set(int key, int value){
        if (!keyToPre.containsKey(key)){
            ListNode node = new ListNode(key, value, null);
            pushBack(node);
            if (keyToPre.size() > capacity){
                popTop();
            }
            return;
        }
        ListNode preNode = keyToPre.get(key);
        kick(preNode);
        tail.value = value;
    }

    class ListNode{
        int key, value;
        ListNode next;
        public ListNode(int key, int value, ListNode next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
