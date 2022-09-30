package junior.datastructure;

import java.util.HashMap;

/**
 * https://www.lintcode.com/problem/105/solution/17113?fromId=161&_from=collection
 *
 * 描述
 * 给出一个链表，每个节点包含一个额外增加的随机指针，其可以指向链表中的任何节点或空的节点。
 * 返回其链表的深度拷贝。
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head){
        if (head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;

        while (head != null){
            if (map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
            pre = newNode;
            if (head.random != null){
                if (map.containsKey(head.random)){
                    pre.random = map.get(head.random);
                }else {
                    pre.random = new RandomListNode(head.random.label);
                    map.put(head.random, pre.random);
                }
            }
            head = head.next;
        }
        return dummy.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x){
            this.label = x;
        }
    }
}
