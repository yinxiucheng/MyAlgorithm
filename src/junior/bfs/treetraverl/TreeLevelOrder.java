package junior.bfs.treetraverl;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root){
        if (null == root) return  new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> listWrapper = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> listInner = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                listInner.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            listWrapper.add(listInner);
        }
        return listWrapper;
    }

    //双端队列
    public List<List<Integer>> levelOrder2(TreeNode root){
        List result = new ArrayList();
        if (null == root) return  result;

        List<TreeNode> q1 = new ArrayList<>();
        List<TreeNode> q2 = new ArrayList<>();
        q1.add(root);
        while (q1.size() > 0){
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < q1.size(); i++) {
                TreeNode node = q1.get(i);
                level.add(node.val);
                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }
            result.add(level);
            List<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        return result;
    }


    /**
     *  DummyNode
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root){
        List result = new ArrayList();
        if (null == root) return  result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (null == node){
               result.add(level);
               level = new ArrayList<>();
                q.offer(null);
                continue;
            }
            level.add(node.val);
            if (null != node.left) q.offer(node.left);
            if (null != node.right) q.offer(node.right);
        }
        return result;
    }
}
