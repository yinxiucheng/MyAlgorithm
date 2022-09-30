package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * 468 · 对称二叉树
 *
 * https://www.lintcode.com/problem/468/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 *          1
 *         / \
 *        2   2
 *       / \ / \
 *       3 4 4 3
 *
 */
public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        boolean b = root1.val == root2.val;
        return b && check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}
