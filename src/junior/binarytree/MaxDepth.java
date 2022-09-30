package junior.binarytree;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/97/?fromId=161&_from=collection
 *
 */
public class MaxDepth {

    public int maxDepth(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int depth = Math.max(leftDepth, rightDepth) + 1;

        return depth;
    }
}
