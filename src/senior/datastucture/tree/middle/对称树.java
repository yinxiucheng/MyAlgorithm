package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

/**
 * 1360 · 对称树
 *
 * https://www.lintcode.com/problem/1360/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 对称树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
