package junior.divconquer;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/902/?fromId=161&_from=collection
 */
public class KthSmallest {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public static int kthSmallest(TreeNode root, int k) {
       if (null == root){
           return 0;
       }
       List<TreeNode> nodes = new ArrayList<>();
        midTraverse(nodes, root);
       if (nodes.size() < k){
           return 0;
       }
       return nodes.get(k - 1).val;
    }

    private static void midTraverse(List<TreeNode> list, TreeNode  node){
        if (null == node){
            return;
        }
        midTraverse(list, node.left);
        list.add(node);
        midTraverse(list, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        kthSmallest(root, 2);
    }


    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest2(TreeNode root, int k) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        for (int i = 0; i < k - 1; i++) {
            TreeNode node = stack.pop();
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return stack.peek().val;
    }

    public int kthSmallest3(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        while (root!= null){
            stack.push(root);
            root = root.left;
        }

        for (int i = 0; i < k - 1; i++) {
            TreeNode cur = stack.peek();

            if (cur.right == null){
                root = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == root){
                    root =  stack.pop();
                }
            }else {
                root = cur.right;
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
            }

        }
        return stack.peek().val;
    }
}
