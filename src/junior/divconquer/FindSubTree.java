package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/596/solution/16632?fromId=161&_from=collection
 *
 * 描述
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。
 * 输入输出数据范围都在int内。
 */
public class FindSubTree {
    private int minSum = Integer.MAX_VALUE;
    TreeNode minNode = null;
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (null == root){
            return null;
        }
        getSum(root);
        return minNode;
    }

    private int getSum(TreeNode root){
        if (root == null){
            return 0;
        }

        int sum = getSum(root.left) + getSum(root.right) + root.val;
        if (sum < minSum){
            minSum = sum;
            minNode = root;
        }
        return sum;
    }


    class ResultType{
        int sum;
        int maxSum;
        TreeNode maxTreeNode;

        ResultType(int sum,int maxSum, TreeNode node){
            this.sum = sum;
            this.maxSum = maxSum;
            this.maxTreeNode = node;
        }
    }

    public TreeNode findSubtree(TreeNode root){
        if (null == root){
            return null;
        }
        ResultType resultType = helper(root);
        return resultType.maxTreeNode;
    }

    private ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(0, Integer.MIN_VALUE, null);
        }
        ResultType leftResult = helper(node.left);
        ResultType rightResult = helper(node.right);
        int sum = leftResult.sum + rightResult.sum + node.val;
        int maxSub = Math.max(leftResult.maxSum, rightResult.maxSum);
        if (sum > maxSub) {
            return new ResultType(sum, sum, node);
        } else if (leftResult.maxSum > rightResult.maxSum) {
            return new ResultType(sum, leftResult.maxSum, leftResult.maxTreeNode);
        } else {
            return new ResultType(sum, rightResult.maxSum, rightResult.maxTreeNode);
        }
    }
}
