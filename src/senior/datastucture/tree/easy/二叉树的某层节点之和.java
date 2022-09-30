package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的某层节点之和
 *
 * https://www.lintcode.com/problem/482/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 二叉树的某层节点之和 {

    public int levelSum(TreeNode root, int level) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curLevel = 0;

        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            curLevel ++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (curLevel == level){
                   sum +=  node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            if (curLevel == level){
                return sum;
            }
        }

        return sum;
    }
}
