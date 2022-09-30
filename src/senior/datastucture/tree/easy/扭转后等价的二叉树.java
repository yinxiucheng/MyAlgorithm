package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * 470 · 扭转后等价的二叉树
 * https://www.lintcode.com/problem/470/description?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 扭转后等价的二叉树 {

    public boolean isTweakedIdentical(TreeNode A, TreeNode B) {
        if (A == null && B == null){
            return true;
        }

        if (A == null || B == null){
            return false;
        }

        if (A.val != B.val){
            return false;
        }

        if (isTweakedIdentical(A.left, B.left) && isTweakedIdentical(A.right, B.right)){
            return true;
        }

        if (isTweakedIdentical(A.left, B.right) && isTweakedIdentical(A.right, B.left)){
            return true;
        }

        return false;
    }
}
