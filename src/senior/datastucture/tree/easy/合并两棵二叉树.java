package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 *
 */
public class 合并两棵二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }else if (t1 == null){
            return t2;
        }else if (t2 == null){
            return t1;
        }

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }

}
