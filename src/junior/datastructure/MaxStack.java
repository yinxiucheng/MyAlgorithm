package junior.datastructure;

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
public class MaxStack {
    private Stack<Integer> mStack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        maxStack = new Stack<>();
        mStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        mStack.push(x);
        if (maxStack.isEmpty()){
            maxStack.push(x);
        }else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
    }

    public int pop() {
        maxStack.pop();
        return mStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return mStack.peek();
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        return maxStack.peek();
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max){
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()){
            push(buffer.pop());
        }
        return max;
    }
}
