package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/175/description?fromId=161&_from=collection
 *
 * 描述
 * 翻转一棵二叉树。左右子树交换。
 */
public class InvertBinaryTree {

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (null == root){
            return;
        }

        TreeNode tempRoot = root.left;
        root.left = root.right;
        root.right = tempRoot;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

}
