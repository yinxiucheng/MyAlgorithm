package junior.datastructure;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/40/?fromId=161&_from=collection
 *
 * 描述
 * 正如标题所述，你只能使用两个栈来实现队列的一些操作。
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * pop和top方法都应该返回第一个元素的值。
 *
 */
public class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> buffer;

    public MyQueue(){
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void moveItems(){
        while (!stack.isEmpty()){
            buffer.push(stack.pop());
        }
    }

    public void push(int val){
        stack.push(val);
    }

    public int pop(){
        if (buffer.isEmpty()){
            moveItems();
        }
        return buffer.pop();
    }

    public int top(){
        if(buffer.isEmpty()){
            moveItems();
        }
        return buffer.peek();
    }
}
