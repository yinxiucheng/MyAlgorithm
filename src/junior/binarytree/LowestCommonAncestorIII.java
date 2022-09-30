package junior.binarytree;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/578/description?fromId=161&_from=collection
 *
 * 注意，普通的二叉树，不是搜索二叉树。
 */
public class LowestCommonAncestorIII {

    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B){
        ResultType resultType = helper(root, A, B);
        if (resultType.aExist || resultType.bExist){
            return resultType.node;
        }
        return  null;
    }

    private static ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new ResultType(false, false, null);
        }
        ResultType leftResult = helper(root.left, A, B);
        ResultType rightResult = helper(root.right, A, B);

        boolean aExist = leftResult.aExist || rightResult.aExist || root == A;//A 在 左子树，右子树，或者为root
        boolean bExist = leftResult.bExist || rightResult.bExist || root == B;// A 在右子树、左子树，或者为root；

        if (root == A || root == B){ // A、B为
            return new ResultType(aExist, bExist, root);
        }

        if (leftResult.node != null && rightResult.node != null)
            return new ResultType(aExist, bExist, root);
        if (leftResult.node != null)
            return new ResultType(aExist, bExist, leftResult.node);
        if (rightResult.node != null)
            return new ResultType(aExist, bExist, rightResult.node);

        return new ResultType(aExist, bExist, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);
        TreeNode rightL2 = new TreeNode(5);
        TreeNode rightR2 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        right1.left = rightL2;
        right1.right = rightR2;

        TreeNode result = lowestCommonAncestor3(root, new TreeNode(5), new TreeNode(6));
        System.out.print("result is " + result);
    }

    static class ResultType{
        boolean aExist;
        boolean bExist;
        TreeNode node;

        public ResultType(boolean aExist, boolean bExist, TreeNode root){
            this.aExist = aExist;
            this.bExist = bExist;
            this.node = root;
        }
    }
}
