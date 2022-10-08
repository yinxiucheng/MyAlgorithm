package senior.datastucture.tree.连续序列;

import junior.datamodel.TreeNode;

/**
 *
 * https://www.lintcode.com/problem/595/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 二叉树最长连续序列 {

    public int longestConsecutive(TreeNode root) {
       int[] result = new int[2];
       helper(root, result);
       return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (null == root){
            return 0;
        }
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        int subtreeLongest = 1;
        if (null != root.left && root.val + 1 == root.left.val){
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }

        if (null != root.right && root.val + 1 == root.right.val){
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        if (subtreeLongest > result[0]){
            result[0] = subtreeLongest;
        }
        return subtreeLongest;
    }
}
