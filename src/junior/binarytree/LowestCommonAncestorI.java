package junior.binarytree;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/88/?fromId=161&_from=collection
 * 描述
 * 给定二叉树的根节点和两个子节点，找到两个节点的最近公共父节点(LCA)。最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 */
public class LowestCommonAncestorI {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (null == root){
            return null;
        }
        if (root == A || root == B){
            return root;
        }
        TreeNode leftParent = lowestCommonAncestor(root.left, A, B);
        TreeNode rightParent = lowestCommonAncestor(root.right, A, B);
        if (leftParent != null && rightParent != null){
            return root;
        }
        if (leftParent != null){
            return leftParent;
        }
        if (rightParent != null){
            return rightParent;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);
        TreeNode leftL2 = new TreeNode(5);
        TreeNode leftR2 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        right1.left = leftL2;
        right1.right = leftR2;

        TreeNode parent = lowestCommonAncestor(root, left1, leftL2);
        System.out.print("parent is " + parent.val);
    }
}
