package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/1106/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTreeHelper(nums, 0, nums.length);
    }

    public TreeNode buildTreeHelper(int[] nums, int start, int end){
        if (start == end){
            return null;
        }

        int maxIndex = start;
        int max = nums[start];
        for (int i = start; i < end; i++) {
            if (max < nums[i]){
                maxIndex = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = buildTreeHelper(nums, start, maxIndex);
        root.right = buildTreeHelper(nums, maxIndex + 1, end);
        return root;
    }
}
