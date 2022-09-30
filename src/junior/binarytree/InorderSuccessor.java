package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/448
 *
 * 描述
 * 给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有则返回null
 */
public class InorderSuccessor {

    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (null == root){
            return null;
        }
        TreeNode successor = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()){
            node = stack.peek();
            TreeNode cur = stack.pop();
            if (node.right != null){
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
            if (cur == p && !stack.isEmpty()){
                successor = stack.peek();
                break;
            }
        }
        return successor;
    }
}
