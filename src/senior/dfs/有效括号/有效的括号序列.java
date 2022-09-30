package senior.dfs.有效括号;

import java.util.Stack;

/**
 * 423 · 有效的括号序列
 * https://www.lintcode.com/problem/423
 *
 *
 * 描述
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 *
 * 括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但 "([)]" 则是无效的括号。
 */
public class 有效的括号序列 {

    public static void main(String[] args) {
        String test = "()";
        isValidParentheses(test);
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        while (count < s.length()){
            if (stack.isEmpty()){
                char curC = s.charAt(count);
                if (isStackChar(curC)){
                    stack.push(curC);
                    count ++;
                }else {
                    return false;
                }
            } else {
                char topStackChar = stack.peek();
                char curC = s.charAt(count);
                if (isStackChar(curC)){
                    stack.push(curC);
                    count ++;
                } else if (match(topStackChar, curC)){
                    stack.pop();
                    count++;
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isStackChar(char c){
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean match(char c1, char c2){
        if (c2 == ')' && c1 == '(' || c2 == '}' && c1 == '{' || c2 == ']' && c1 == '['){
            return true;
        }
        return false;
    }
}
