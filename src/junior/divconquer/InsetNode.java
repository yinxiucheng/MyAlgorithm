package junior.divconquer;

import junior.datamodel.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/85/?fromId=161&_from=collection
 *
 * 描述
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 *
 * 你需要保证该树仍然是一棵二叉查找树。
 */
public class InsetNode {

    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        TreeNode rightL2 = new TreeNode(3);

        TreeNode node = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        right1.left = rightL2;

        TreeNode result = insertNode(root, node);
        System.out.println(" The result is " + result.val);
        printBinaryTree(root);
    }

    //序列化二叉树
    private static void printBinaryTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + ",");
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }
}
