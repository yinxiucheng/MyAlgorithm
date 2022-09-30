package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/467/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 完全二叉树 {

    public boolean isComplete(TreeNode root) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean shouldEnd = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    if (shouldEnd){
                        return false;
                    }
                    queue.offer(node.left);
                }else {
                    shouldEnd = true;
                }

                if (node.right != null){
                    if (shouldEnd){
                        return false;
                    }
                    queue.offer(node.right);
                }else {
                    shouldEnd = true;
                }
            }
        }
        return true;
    }
}
