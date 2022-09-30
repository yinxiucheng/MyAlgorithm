package senior.dfs.有效括号;

import java.util.Stack;

/**
 * 193 · 最长有效括号
 *
 * https://www.lintcode.com/problem/193
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class 最长有效括号 {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int stackValidCount = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            if (curC == '('){
                stack.push(curC);
                continue;
            }
            if (stack.isEmpty()){
                result = Math.max(result, stackValidCount);
                stackValidCount = 0;
                continue;
            }
            stack.pop();
            stackValidCount += 2;
        }
        result = Math.max(result, stackValidCount);
        return result;
    }
}
