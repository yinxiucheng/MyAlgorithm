package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1317 · 统计完全树节点数
 */
public class 统计完全树节点数 {

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            count ++;
            if (curNode.left != null){
                queue.offer(curNode.left);
            }

            if (curNode.right != null){
                queue.offer(curNode.right);
            }
        }
        return count;
    }
}
