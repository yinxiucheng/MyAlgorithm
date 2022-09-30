package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二叉树每层的平均数 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            int count = size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null){
                    count --;
                    continue;
                }
                sum += node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add((sum * 1.0)/count);
        }
        return result;
    }
}
