package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/66/solution/16959
 *
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 *
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *      2
 *     /
 *   3
 * return [1,2,3].
 *
 *  Note: Recursive solution is trivial, could you do it iteratively?
 */
public class PreOrderTraversal {

    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root){
            return  result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            result.add(node.val);
            if (node.right != null){
                nodeStack.add(node.right);
            }
            if (node.left != null){
                nodeStack.add(node.left);
            }
        }
        return result;
    }

}
