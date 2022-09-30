package senior.datastucture.tree.easy;

import junior.datamodel.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历 {

    public List<List<Integer>> levelOrder(UndirectedGraphNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == root){
            return results;
        }
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                list.add(node.label);
                for (UndirectedGraphNode neighbor: node.neighbors) {
                    queue.offer(neighbor);
                }
            }
            results.add(list);
        }
        return results;
    }
}
