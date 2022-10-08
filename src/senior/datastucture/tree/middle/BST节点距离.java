package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/1561/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 * 1561 · BST节点距离
 *
 */
public class BST节点距离 {

    public static void main(String[] args) {
        int[] numbers = {10,18,12,16,19,13,20,3,1,7,14};
        int result = bstDistance(numbers, 18, 7);
        System.out.println("the result is " + result);
    }

    public static int bstDistance(int[] numbers, int node1, int node2) {

        if (null == numbers || numbers.length < 2){
            return -1;
        }
        //corner Test,  node1, node2 all be contained by array numbers. if not, return -1;
        //1. build BST
        TreeNode treeNode = buildBST(numbers);
        //分治， 左子树，右子树。
        int min = Math.min(node1, node2);
        int max = Math.max(node1, node2);
        if (findInBST(treeNode, min) == -1 || findInBST(treeNode, max) == -1 ){
            return -1;
        }
        return helper(treeNode, min, max);
    }

    private boolean check(int[] numbers, int node1, int node2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i ++) {
            set.add(numbers[i]);
        }
        if (set.contains(node1) && set.contains(node2)) {
            return true;
        }
        return false;
    }

    private static TreeNode insert(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            root.left = insert(root.left, val);
        }else if (root.val < val){
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static TreeNode buildBST(int[] numbers){
        TreeNode root = new TreeNode(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            insert(root, numbers[i]);
        }
        return root;
    }

    public static int helper(TreeNode root, int left, int right){
        if (left > root.val) {
            return helper(root.right, left, right);
        } else if (right < root.val) {
            return helper(root.left, left, right);
        }
        return findInBST(root, left) + findInBST(root, right);
    }

    private static int findInBST(TreeNode root, int val){
        if (root == null){
            return -1;
        }
        int count = 0;
        TreeNode node = root;
        while (node != null){
            if (val > node.val){
                node = node.right;
            }else if (val < node.val){
                node = node.left;
            } else {
                return count;
            }
            count ++;
        }
        return -1;
    }
}
