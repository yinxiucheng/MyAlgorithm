package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

/**
 * 73 · 前序遍历和中序遍历树构造二叉树
 *
 */
public class 前序遍历和中序遍历树构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int position = findPosition(inorder, rootVal);
        int leftLen = position - inStart;
        int rightLen = inEnd - position;

        root.left = helper(preorder, preStart + 1, preStart + leftLen, inorder, inStart, position - 1);
        root.right = helper(preorder, preEnd - rightLen + 1, preEnd, inorder, position + 1, inEnd);

        return root;
    }

    private int findPosition(int[] inorder, int rootVal){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal){
                return i;
            }
        }
        return 0;
    }
}
