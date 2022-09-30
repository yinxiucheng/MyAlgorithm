package junior.bfs.treetraverl;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/69/description
 *
 * 二叉树的层遍历
 */
public class LevelOrderTree {

    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (null == root){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode parent = queue.poll();
                if (parent != null){
                    level.add(parent.val);
                    if (parent.left != null){
                        queue.offer(parent.left);
                    }
                    if (parent.right != null){
                        queue.offer(parent.right);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
