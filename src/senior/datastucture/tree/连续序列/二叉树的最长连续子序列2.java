package senior.datastucture.tree.连续序列;

import junior.datamodel.TreeNode;

/**
 *
 */
public class 二叉树的最长连续子序列2 {

    public int longestConsecutive2(TreeNode root) {
        return helper(root).max_length;
    }

    private ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(0, 0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int max_down = 0;
        int max_up = 0;

        if (root.left != null && root.val + 1 == root.left.val){
            max_down = Math.max(max_down, left.max_down + 1);
        }

        if (root.left != null && root.val - 1 == root.left.val){
            max_up = Math.max(max_up, left.max_up + 1);
        }

        if (root.right != null && root.val + 1 == root.right.val){
            max_down = Math.max(max_down, right.max_down + 1);
        }

        if (root.right != null && root.val - 1 == root.right.val){
            max_up = Math.max(max_up, right.max_up + 1);
        }

        int len = max_down + 1 + max_up;
        len = Math.max(len, Math.max(left.max_length, right.max_length));
        return new ResultType(len, max_down, max_up);
    }

    class ResultType{
        int max_length;
        int max_up;
        int max_down;

        public ResultType(int max_length, int max_down, int max_up){
            this.max_length = max_length;
            this.max_down = max_down;
            this.max_up = max_up;
        }
    }
}
