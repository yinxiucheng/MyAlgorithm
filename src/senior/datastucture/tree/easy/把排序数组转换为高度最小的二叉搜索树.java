package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * 177 · 把排序数组转换为高度最小的二叉搜索树
 *
 * https://www.lintcode.com/problem/177/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 把排序数组转换为高度最小的二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] a) {
        if (null == a || a.length == 0){
            return null;
        }
        return buildTree(a, 0, a.length - 1);
    }

    private TreeNode buildTree(int[] a, int start, int end){
        if (start == end){
            return new TreeNode(a[start]);
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(a[mid]);
        if (mid - 1 >= start){
            root.left = buildTree(a, start, mid - 1);
        }
        if (mid + 1 <= end){
            root.right = buildTree(a, mid + 1, end);
        }

        return root;
    }
}
