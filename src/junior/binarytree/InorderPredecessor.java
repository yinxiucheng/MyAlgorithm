package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/915
 */
public class InorderPredecessor {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        if (null == root){
            return null;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()){
            node = stack.peek();
            stack.pop();
            if (node == p) return pre;
            pre = node;
            if (node.right != null){
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return pre;
    }
}
