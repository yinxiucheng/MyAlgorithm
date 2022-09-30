package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/155/description?fromId=161&_from=collection
 *
 * 描述
 * 给定一个二叉树，找出其最小深度。
 *
 * 二叉树的最小深度为根节点到最近叶子节点的最短路径上的节点数量。
 *
 */
public class MinDepth {

    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode>  queue = new  LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth ++ ;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (null != node.left){
                    queue.offer(node.left);
                }
                if (null != node.right){
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }
}
