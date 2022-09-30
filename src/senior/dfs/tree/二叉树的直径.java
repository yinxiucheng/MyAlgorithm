package senior.dfs.tree;

/**
 * 1181 · 二叉树的直径
 *
 * 给定一颗二叉树，您需要计算树的直径长度。 二叉树的直径是树中任意两个节点之间最长路径的长度。
 *
 */
public class 二叉树的直径 {

    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
        // write your code here
    }

    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        result = Math.max(result, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
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
