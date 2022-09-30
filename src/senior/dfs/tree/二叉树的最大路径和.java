package senior.dfs.tree;

/**
 * 94 · 二叉树中的最大路径和
 *
 * 描述
 * 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
 */
public class 二叉树的最大路径和 {

    public int maxPathSum(TreeNode root) {
        ResultType resultType = getMaxPathSum(root);
        return resultType.maxPath;
    }

    private ResultType getMaxPathSum(TreeNode root){
        if (root == null){
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ResultType left = getMaxPathSum(root.left);
        ResultType right = getMaxPathSum(root.right);

        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, Math.max(0, left.singlePath) + Math.max(0, right.singlePath) + root.val);
        return new ResultType(singlePath, maxPath);
    }

    class ResultType{
        int singlePath, maxPath;

        public ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    class TreeNode{
        TreeNode left, right;
        int val;

        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }
}
