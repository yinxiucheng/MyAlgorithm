package junior.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/494/description
 *
 * 描述
 * 通过两个队列实现一个栈。队列是先进先出(FIFO)。这意味着不能直接弹出队列中的最后一个元素。
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.isEmpty();
        stack.top();
        stack.pop();
        stack.isEmpty();
    }
    private Queue<Integer> queue;
    private Queue<Integer> buffer;

    public MyStack(){
        queue = new LinkedList<>();
        buffer = new LinkedList<>();
    }

    private void swapQueue(){
        Queue temp = queue;
        queue = buffer;
        buffer = temp;
    }

    private void moveItems(){
        while (queue.size() > 1){
            buffer.offer(queue.poll());
        }
    }

    public void push(int val){
        queue.offer(val);
    }

    public void pop(){
        moveItems();
        queue.poll();
        swapQueue();
    }

    public int top(){
        moveItems();
        int item = queue.poll();
        swapQueue();
        queue.offer(item);
        return item;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
