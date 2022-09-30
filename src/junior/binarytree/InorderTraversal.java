package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/67
 *
 */
public class InorderTraversal {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (null == root){
            return results;
        }
        helper(root, results);
        return results;
    }

    //递归函数调用
    private void helper(TreeNode node, List<Integer> results){
        if (null == node){
            return;
        }
        helper(node.left, results);
        results.add(node.val);
        helper(node.right, results);
    }


    //分治法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (null == root){
            return results;
        }
        List<Integer> leftResults = inorderTraversal(root.left);
        List<Integer> rightResults = inorderTraversal(root.right);
        results.addAll(leftResults);
        results.add(root.val);
        results.addAll(rightResults);
        return results;
    }

    //非递归栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (null == root) {
            return results;
        }
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.right == null) {
                temp = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == temp){
                    temp = stack.pop();
                }
            } else {
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            results.add(stack.peek().val);
        }
        return results;
    }

}
