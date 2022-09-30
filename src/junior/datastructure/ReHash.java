package junior.datastructure;

import junior.datamodel.ListNode;

/**
 * https://www.lintcode.com/problem/129/description
 *
 * 描述
 * 哈希表容量的大小在一开始是不确定的。如果哈希表存储的元素太多（如超过容量的十分之一），我们应该将哈希表容量扩大一倍，并将所有的哈希值重新安排。假设你有如下一哈希表：
 *
 * size=3, capacity=4
 */
public class ReHash {

    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (null != node){
                int newIndex = (node.val%capacity + capacity) % capacity;
                if (newTable[newIndex] == null){
                    newTable[newIndex] = new ListNode(node.val);
                }else {
                    ListNode dummy = newTable[newIndex];
                    while (null != dummy.next){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(node.val);
                }
                node = node.next;
            }
        }
        return newTable;
    }
}
