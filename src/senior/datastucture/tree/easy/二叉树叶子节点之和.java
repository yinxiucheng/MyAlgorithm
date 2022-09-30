package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/481/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 二叉树叶子节点之和 {

    public int leafSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode.left == null && curNode.right == null){
                sum += curNode.val;
            }
            if (curNode.left != null){
                queue.offer(curNode.left);
            }

            if (curNode.right != null){
                queue.offer(curNode.right);
            }
        }
        return sum;
    }
}
