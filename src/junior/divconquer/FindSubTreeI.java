package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/597/solution/18594?fromId=161&_from=collection
 * 描述
 * 给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
 */
public class FindSubTreeI {

    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null){
            return null;
        }
        helper(root);
        return subTreeResult.subTreeNode;
    }

    ResultType subTreeResult = null;
    private ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(null, 0, 0);
        }
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType resultType = new ResultType(root, leftResult.sum + rightResult.sum + root.val, leftResult.subSize + rightResult.subSize + 1);

        if (subTreeResult == null || resultType.sum * subTreeResult.subSize  > subTreeResult.sum * resultType.subSize ){
            subTreeResult = resultType;
        }
        return resultType;
    }


    class ResultType{
        int subSize;
        int sum;
        TreeNode subTreeNode;
        ResultType(TreeNode node, int sum, int subSize){
            this.subTreeNode = node;
            this.sum = sum;
            this.subSize = subSize;
        }
    }
}
