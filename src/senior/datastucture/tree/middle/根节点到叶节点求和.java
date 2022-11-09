package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1353 · 根节点到叶节点求和
 *
 * https://www.lintcode.com/problem/1353/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 根节点到叶节点求和 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
//        sumNumbers(root);
    }

    public  int sumNumbers(TreeNode root) {
        // write your code here
        if (root == null) return 0;

        int curSum = 0;
        int[] result = {0};
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, curSum, result);
        return result[0];
    }

    private  void dfs(TreeNode node, int curSum, int[] result){
        if (node.left == null && node.right == null){
            result[0] += curSum * 10 + node.val;
            return;
        }

        curSum = curSum * 10 + node.val;
        if (node.left != null){
            dfs(node.left, curSum, result);
        }

        if (node.right != null){
            dfs(node.right, curSum, result);
        }
    }

}
