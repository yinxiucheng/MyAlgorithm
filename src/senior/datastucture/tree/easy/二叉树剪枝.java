package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/***
 * https://www.lintcode.com/problem/1003/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 *
 */
public class 二叉树剪枝 {


    public TreeNode pruneTree(TreeNode root) {
        if (null == root){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null? null : root;
    }

}
