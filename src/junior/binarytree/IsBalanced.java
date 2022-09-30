package junior.binarytree;

import junior.datamodel.TreeNode;

public class IsBalanced {

    public boolean isBalanced(TreeNode root){
        if (null == root){
            return true;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        boolean isBalancedLeft = isBalanced(root.left);
        boolean isBalancedRight = isBalanced(root.right);
        return isBalancedLeft && isBalancedRight && Math.abs(leftDepth - rightDepth) <= 1;
    }

    private int getTreeDepth(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public boolean isBalanced2(TreeNode root){
        if (null == root){
            return true;
        }
        ResultType resultType = divideConquer(root);
        return resultType.isBalanced;
    }

    private ResultType divideConquer(TreeNode node){
        if (node == null){
            return new ResultType(0, true);
        }
        ResultType leftResultType = divideConquer(node.left);
        ResultType rightResultType = divideConquer(node.right);

        int depth = Math.max(leftResultType.treeDepth, rightResultType.treeDepth) + 1;
        boolean isBalanced = leftResultType.isBalanced && rightResultType.isBalanced && Math.abs(leftResultType.treeDepth - rightResultType.treeDepth) <= 1;
        return new ResultType(depth, isBalanced);
    }

    class ResultType{
        int treeDepth;
        boolean isBalanced;
        public ResultType(int treeDepth, boolean isBalanced){
            this.isBalanced = isBalanced;
            this.treeDepth = treeDepth;
        }
    }
}



