package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/453/?fromId=161&_from=collection
 */
public class Flatten {

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public static void flatten(TreeNode root) {
       helper(root);
    }

    private static TreeNode helper(TreeNode root){
        if (null == root){
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        if (null != leftLast){
            leftLast.right = root.right;
            root.right  = root.left;
            root.left = null;
        }
        if (null != rightLast){
            return rightLast;
        }
        if (null != leftLast){
            return leftLast;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode leftL2 = new TreeNode(4);
        TreeNode leftR2 = new TreeNode(5);
        TreeNode rightR2 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        left1.left = leftL2;
        left1.right = leftR2;
        right1.right = rightR2;

        flatten(root);
        TreeNode curNode = root;
        while (curNode != null){
            if (curNode.right != null){
                System.out.print(curNode.val + "->");
            }else {
                System.out.print(curNode.val);
            }
            curNode = curNode.right;
        }
    }
}
