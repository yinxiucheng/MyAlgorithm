package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/95/?fromId=161&_from=collection
 *
 */
public class IsValidBST {

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        boolean leftBST = isValidBST(root.left);
        boolean rightBST = isValidBST(root.right);
        boolean rootBST = false;

        TreeNode leftRNode = findBSTMax(root.left);
        TreeNode rightLNode = findBSTMin(root.right);

        if (leftRNode != null && rightLNode != null) {
            rootBST = leftRNode.val < root.val && root.val < rightLNode.val;
        } else if (leftRNode != null) {
            rootBST = leftRNode.val < root.val;
        } else if (rightLNode != null){
            rootBST = root.val < rightLNode.val;
        }
        return rootBST && leftBST && rightBST;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode leftL2 = new TreeNode(1);
        TreeNode leftR2 = new TreeNode(100);

        root.left = left;
        left.left = leftL2;
        left.right = leftR2;
        boolean isValidBST = isValidBST(root);
        System.out.println("The result is " + isValidBST);
    }

    private static TreeNode findBSTMax(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode cur = node;
        while (cur.right != null){
            cur = cur.right;
        }
        return cur;
    }

    private static TreeNode findBSTMin(TreeNode node){
        if (null == node){
            return null;
        }
        TreeNode cur = node;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur;
    }


}
