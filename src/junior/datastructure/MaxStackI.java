package junior.datastructure;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/859/
 *
 * 描述
 * 设计一个支持push，pop，top，peekMax和popMax操作的最大栈。
 *
 * push(x) -- 将元素x添加到栈中。
 * pop() -- 删除栈中最顶端的元素并将其返回。
 * top() -- 返回栈中最顶端的元素。
 * peekMax() -- 返回栈中最大的元素。
 * popMax() -- 返回栈中最大的元素，并将其删除。如果有多于一个最大的元素，只删除最靠近顶端的一个元素。
 */
public class MaxStackI {
    Stack<Item> mStack;
    PriorityQueue<Item> mHeap;
    HashSet<Item> mSet;
    int count;

    public MaxStackI() {
        mStack = new Stack<>();
        mHeap = new PriorityQueue<>();
        mSet = new HashSet<>();
    }

    private void deleteItemInStack(){
        while (!mStack.isEmpty() && mSet.contains(mStack.peek())){
            Item item = mStack.pop();
            mSet.remove(item);
        }
    }

    private void deleteItemInHeap(){
        while (!mHeap.isEmpty() && mSet.contains(mHeap.peek())){
            Item item = mHeap.poll();
            mSet.remove(item);
        }
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        Item item = new Item(x, count++);
        mStack.push(item);
        mHeap.offer(item);
    }

    public int pop() {
        deleteItemInStack();
        Item item = mStack.pop();
        mSet.add(item);
        return item.val;
    }

    /*
     * @return: An integer
     */
    public int top() {
        deleteItemInStack();
        Item item = mStack.peek();
        return item.val;
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        deleteItemInHeap();
        Item item = mHeap.peek();
        return item.val;
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        deleteItemInHeap();
        Item item = mHeap.poll();
        mSet.add(item);
        return item.val;
    }

    class Item implements Comparable<Item>{
        public int val;
        public int count;

        public Item(int val, int count){
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Item another) {
            if (another.val != val){
                return another.val - val;
            }
            return another.count - count;
        }
    }
}


