package senior.datastucture.tree.middle;


import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * 880 · 字符串构造二叉树
 *
 * https://www.lintcode.com/problem/880/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 * 输入: "-4(2(3)(1))(6(5))"
 * 输出: {-4,2,6,3,1,5}
 * 说明:
 * 输出应该如下所示：
 *       -4
 *      /  \
 *     2    6
 *    / \   /
 *   3   1 5
 */
public class 字符串构造二叉树 {

    public static void main(String[] args) {
        String s = "-4(2(3)(1))(6(5)(7))";
        str2tree(s);
    }

    public static TreeNode str2tree(String s) {
        return buildTree(s);
    }

    private static TreeNode buildTree(String s){
        Stack<Character> stack = new Stack<>();
        boolean isFirst = false;
        int firstIndex = -1;
        int leftEndIndex = -1;
        int rightIndex = -1;
        int rightEndIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='('){
                if (!isFirst){
                    isFirst = true;
                    firstIndex = i;
                }
                stack.push(c);
            } else if (c == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                    if (stack.isEmpty()){
                        leftEndIndex = i;
                        if (leftEndIndex < s.length() - 1){
                            rightIndex = leftEndIndex + 1;
                            rightEndIndex = s.length() - 1;
                        }
                        break;
                    }
                }
            }
        }

        if (firstIndex == -1){
            return  new TreeNode(Integer.parseInt(s));
        }
        int rootVal = Integer.parseInt(s.substring(0, firstIndex));
        TreeNode root = new TreeNode(rootVal);

        if (leftEndIndex != -1){
            String leftChildStr = s.substring(firstIndex + 1, leftEndIndex);
            root.left = buildTree(leftChildStr);
        }

        if (rightIndex != -1 && rightEndIndex != -1){
            String rightChildStr = s.substring(rightIndex + 1, rightEndIndex);
            root.right = buildTree(rightChildStr);
        }

        return root;
    }
}
