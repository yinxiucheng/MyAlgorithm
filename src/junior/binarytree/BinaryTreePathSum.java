package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/376/solution?fromId=161&_from=collection
 *
 * 描述
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 *
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 */
public class BinaryTreePathSum {
    /**
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     *          we will sort your return value in output
     */
    //回溯递归 遍历法。
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        //包含当前节点的路径。
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        int sum = root.val;// 路径上path 节点的和。
        travers(root, sum, path, target, result);
        return result;
    }

    private void travers(TreeNode root, int sum, List<Integer> path, int target, List<List<Integer>> result){

        if (root.left == null && root.right == null){
            path.add(root.val);
            if (sum + root.val == target){
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        if (root.left != null){
            path.add(root.left.val);
            travers(root, sum + root.left.val, path, target, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null){
            path.add(root.right.val);
            travers(root, sum + root.right.val, path, target, result);
            path.remove(path.size() - 1);
        }
    }

    //分治法
    public static List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Handle null
        if (root == null) {
            return result;
        }
        // Handle leaf
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> rootList = new ArrayList<Integer>();
            rootList.add(root.val);
            result.add(rootList);
            return result;
        }
        // Divide
        if (null != root.left){
            List<List<Integer>> leftResult = binaryTreePathSum2(root.left, target - root.val);
            // Merge results
            for (List<Integer> l : leftResult) {
                l.add(0, root.val);
                result.add(l);
            }
        }

        if (null != root.right){
            List<List<Integer>> rightResult = binaryTreePathSum2(root.right, target - root.val);
            for (List<Integer> r : rightResult) {
                r.add(0, root.val);
                result.add(r);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(4);

        TreeNode leftL2 = new TreeNode(2);
        TreeNode leftR2 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        left1.left = leftL2;
        left1.right = leftR2;

        List<List<Integer>> result = binaryTreePathSum2(root, 5);
        printResults(result);
    }

    private static void printResults(List<List<Integer>> result){
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            List<Integer> path = result.get(i);
            System.out.print("[");
            for (int j = 0; j < path.size(); j++) {
                int value = path.get(j);
                System.out.print("" + value);
                if (j != path.size() - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != result.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

}
