package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/71/description?fromId=161&_from=collection
 * 描述
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 *
 */
public class ZigzagLevelOrder {

    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == root){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            if (level % 2 == 0){
                Collections.reverse(list);
            }
            results.add(list);
        }
        return results;
    }
}
