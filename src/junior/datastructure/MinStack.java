package junior.datastructure;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mStack;
    private Stack<Integer> minStack;

    public MinStack(){
        minStack = new Stack<>();
        mStack = new Stack<>();
    }

    public void push(int number) {
        mStack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else if(number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public Integer pop(){
        if (minStack.peek() == mStack.peek()){
            minStack.pop();
        }
        return mStack.pop();
    }

    public Integer min(){
        return minStack.peek();
    }
}
