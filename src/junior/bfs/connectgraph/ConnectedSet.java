package junior.bfs.connectgraph;

import junior.datamodel.UndirectedGraphNode;

import java.util.*;

/**
 * 431 · 找无向图的连通块
 *
 * https://www.lintcode.com/problem/431/
 *
 * 描述
 * 找出无向图中所有的连通块。
 *
 * 图中的每个节点包含一个label属性和一个邻接点的列表。
 *
 * （一个无向图的连通块是一个子图，其中任意两个顶点通过路径相连，且不与整个图中的其它顶点相连。）
 *
 *  你需要返回 label 集合的列表.
 */
public class ConnectedSet {

    /**
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        //构建 Set<> 保存遍历过的点。
        //一层循环遍历 nodes点，通过 queue 去找联通图。

        List<List<Integer>> results = new ArrayList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        for (UndirectedGraphNode node: nodes) {
            if (set.contains(node)){
                continue;
            }else {
                List<Integer> result = new ArrayList<>();
                queue.offer(node);
                set.add(node);
                while (!queue.isEmpty()){
                    UndirectedGraphNode graphNode = queue.poll();
                    result.add(graphNode.label);
                    for (UndirectedGraphNode neighbor: graphNode.neighbors) {
                        if (set.contains(neighbor)){
                            continue;
                        }
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
                Collections.sort(result);
                results.add(result);
            }
        }

        return results;
    }

}
