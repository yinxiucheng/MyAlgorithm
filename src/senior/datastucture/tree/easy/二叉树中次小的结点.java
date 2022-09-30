package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class 二叉树中次小的结点 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        int min = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val > min){
                return node.val;
            }
            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return -1;
    }
}
