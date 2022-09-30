package junior.bfs;

import java.util.*;

/**
 * 618 · 搜索图中节点
 *
 * 描述
 * 给定一张 无向图，一个 节点 以及一个 目标值，返回距离这个节点最近 且 值为目标值的节点，如果不能找到则返回 NULL。
 * 在给出的参数中, 我们用 map 来存节点的值
 *
 */
public class SearchNode {

    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode graphNode = queue.poll();
                if (values.get(graphNode) == target){
                    return graphNode;
                }
                for (UndirectedGraphNode neighbor: graphNode.neighbors) {
                    if (!set.contains(neighbor)){
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }
        }
        return null;
    }




    class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
    }
}
