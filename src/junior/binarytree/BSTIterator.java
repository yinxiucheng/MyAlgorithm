package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/86/
 *
 * 描述
 * 设计实现一个带有下列属性的二叉查找树的迭代器：
 * next()返回BST中下一个最小的元素
 *
 * 元素按照递增的顺序被访问（比如中序遍历）
 * next()和hasNext()的询问操作要求均摊时间复杂度是O(1)O(1)
 */
public class BSTIterator {
    Stack<TreeNode> mStack = new Stack<>();
    /**
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        findMostLeft(root);
    }

    /**
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !mStack.isEmpty();
        // write your code here
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode curr = mStack.peek();
        TreeNode node = curr;
        if (node.right == null){
            node = mStack.pop();
            while (!mStack.isEmpty() && mStack.peek().right == node){
                node = mStack.pop();
            }
        }else {
            node = node.right;
            findMostLeft(node);
        }
        return curr;
    }

    private void findMostLeft(TreeNode node){
        while (node != null){
            mStack.push(node);
            node = node.left;
        }
    }

// Example of iterate a tree:
// BSTIterator iterator = new BSTIterator(root);
// * while (iterator.hasNext()) {
// *    TreeNode node = iterator.next();
// *    do something for node
//                * }
// */

}
