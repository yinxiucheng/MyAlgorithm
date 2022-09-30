package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/632/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 二叉树的最大节点 {

    public TreeNode maxNode(TreeNode root) {
        if (null == root){
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode maxNode = null;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val > max){
                max = node.val;
                maxNode = node;
            }
            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return maxNode;
    }
}
