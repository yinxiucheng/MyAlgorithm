package junior.bfs.treetraverl;

import junior.datamodel.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class KthFloorNode {

    /**
     * @param root: the root node
     * @param k: an integer
     * @return: the number of nodes in the k-th layer of the binary tree
     */
    public int kthfloorNode(TreeNode root, int k) {
        if (null == root){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
             int size = queue.size();
             if (level == k){
                 return size;
             }
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }

        return -1;
    }
}
