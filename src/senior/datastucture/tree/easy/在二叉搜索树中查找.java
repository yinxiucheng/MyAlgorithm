package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/1524/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 在二叉搜索树中查找 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val){
            return root;
        }

        if (val > root.val){
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);

    }
}
