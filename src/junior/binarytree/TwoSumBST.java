package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/689/?fromId=161&_from=collection
 *
 * 描述
 * 给一棵二叉搜索树以及一个整数 n, 在树中找到和为 n 的两个数字。无法找到解时返回 null。
 *
 */
public class TwoSumBST {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n){
        if (null == root){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<Integer> set= new HashSet<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (set.contains(n - node.val)){
                    return new int[]{node.val, n-node.val};
                }
                set.add(node.val);
                if (null != node.left){
                    queue.offer(node.left);
                }
                if (null != node.right){
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }

    public int[] twoSum2(TreeNode root, int n) {
        if (null == root){
            return null;
        }
        int[] result = bfs(root, n);
        return result;
    }

    private int[] bfs(TreeNode root, int n){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int[] result = findPairs(root, node, n);
                if (null != result){
                    return result;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }

    private int[] findPairs(TreeNode root, TreeNode node, int target){
        int findNum = target - node.val;
        TreeNode resultNode = binarySearch(root, findNum);
        if (resultNode == null){
            return null;
        } else if (resultNode != node){
            return new int[]{resultNode.val, node.val};
        }else {
            return null;
        }
    }

    private TreeNode binarySearch(TreeNode root, int findNum){
        if (root.val == findNum){
            return root;
        }else if (root.left != null){
           return binarySearch(root.left, findNum);
        }else if (root.right != null){
            return binarySearch(root.right, findNum);
        }
        return null;
    }
}
