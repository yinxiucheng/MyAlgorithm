package junior.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/134/?fromId=161&_from=collection
 *
 * 描述
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据和写入数据。
 *
 * get(key) 获取数据：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * set(key, value) 写入数据：如果key还没有在缓存中，则设置或插入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 * 最终, 你需要返回每次 get 的数据.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        cache.get(2);
        cache.set(4, 1);
        cache.get(1);
        cache.get(2);
    }
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPre;
    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToPre = new HashMap<>();
        dummy = new ListNode(0, 0, null);
        tail = dummy;
    }

    public void pushBack(ListNode node){
        tail.next = node;
        keyToPre.put(node.key, tail);
        tail = node;
    }

    private void deleteTop(){
        keyToPre.remove(dummy.next.key);
        ListNode next = dummy.next.next;
        dummy.next = next;
        keyToPre.put(next.key, dummy);
    }


    private void kick(ListNode preNode) {
        ListNode cur = preNode.next;
        if (cur.next == null) {
            return;
        }
        preNode.next = cur.next;
        keyToPre.put(cur.next.key, preNode);
        cur.next = null;
        pushBack(cur);
    }


    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPre.containsKey(key)){
           return -1;
        }
        ListNode preNode = keyToPre.get(key);
        ListNode cur = preNode.next;
        kick(preNode);//拿出来放到队尾。
        return cur.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (!keyToPre.containsKey(key)){
            ListNode node = new ListNode(key, value, null);
            pushBack(node);
            if (keyToPre.size() > capacity){
                deleteTop();
            }
        }else {
            kick(keyToPre.get(key));
            tail.value = value;
        }
    }



   private class ListNode{
        int key, value;
        ListNode next;
        ListNode(int key, int value, ListNode next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
