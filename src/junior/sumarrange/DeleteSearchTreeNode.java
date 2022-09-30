package junior.sumarrange;

import junior.datamodel.TreeNode;

/**
 * 删除二叉搜索树中的 value值为 key 的节点。
 */
public class DeleteSearchTreeNode {

    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;

        if (key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode rightMinNode = findRightMinNode(root.right);//
            root.val = rightMinNode.val; //
            root.right = deleteNode(root.right, rightMinNode.val);
            return root;
        }
    }

    private TreeNode findRightMinNode(TreeNode rootNode){
        if (rootNode.left == null) return rootNode;
        return findRightMinNode(rootNode.left);
    }
}
