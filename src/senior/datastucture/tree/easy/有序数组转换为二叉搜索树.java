package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

public class 有序数组转换为二叉搜索树 {

    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        if (null == nums){
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }

}
