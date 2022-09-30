package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/246/?fromId=161&_from=collection
 *
 * 描述
 * 给一棵二叉树和一个目标值，设计一个算法找到二叉树上的和为该目标值的所有路径。路径可以从任何节点出发和结束，但是需要是一条一直往下走的路线。也就是说，路径上的节点的层级是逐个递增的。
 *
 */
public class BinaryTreePathsSumII {

    /**
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     *          we will sort your return value in output
     */
    public static List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        if (root == null)
            return results;
        findSum(root, target, buffer, 0, results);
        return results;
    }


    private static void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level, List<List<Integer>> results){
        if (head == null) return;
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level;i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level; ++j)
                    temp.add(buffer.get(j));
                results.add(temp);
            }
        }
        findSum(head.left, sum, buffer, level + 1, results);
        findSum(head.right, sum, buffer, level + 1, results);
        buffer.remove(buffer.size() - 1);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode leftR2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(2);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = leftR2;
        right1.left = right2;

        List<List<Integer>> results = binaryTreePathSum2(root, 6);
        printResults(results);
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
