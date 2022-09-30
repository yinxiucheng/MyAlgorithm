package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

/**
 * 72 · 中序遍历和后序遍历树构造二叉树
 *
 * https://www.lintcode.com/course/43/learn/72?chapterId=293&sectionId=1718&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A43%22%7D&ac=false
 *
 *
 */
public class 中序遍历和后序遍历树构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int position = findPosition(inorder, rootVal);
        int leftLen = position - inStart;
        int rightLen = inEnd - position;
        root.left = helper(inorder, inStart, position - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = helper(inorder, position + 1, inEnd, postorder, postEnd - rightLen,  postEnd - 1);
        return root;
    }

    private int findPosition(int[] inorder, int val){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val){
                return i;
            }
        }
        return 0;
    }
}
