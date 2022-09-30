package junior.bfs.topsort;

import junior.datamodel.DirectedGraphNode;

import java.util.*;

/**
 * 127 · 拓扑排序
 *  https://www.lintcode.com/problem/127/
 *
 *  描述
 * 给定一个有向图，图节点的拓扑排序定义如下:
 *
 * 对于图中的每一条有向边 A -> B , 在拓扑排序中A一定在B之前.
 * 拓扑排序中的第一个节点可以是图中的任何一个没有其他节点指向它的节点.
 * 针对给定的有向图找到任意一种拓扑排序的顺序.
 *
 * 样例 1：
 *
 * 输入：
 *
 * graph = {0,1,2,3#1,4#2,4,5#3,4,5#4#5}
 *
 * 图如下所示:
 *
 * picture
 *
 * 拓扑排序可以为:
 * [0, 1, 2, 3, 4, 5]
 * [0, 2, 3, 1, 5, 4]
 * ...
 * 您只需要返回给定图的任何一种拓扑顺序。
 *
 * 挑战
 * 能否分别用BFS和DFS完成？
 */
public class TopSort {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> results = new ArrayList<>();
        //计算 graph 中入度 size 为 0 的点
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                // node -> neighbor, neighbor 的 入度 +1。
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        //当这个 graph 中有两个入度为0 的点时，是没法完成 TopSort,然后遍历所有的点的。
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node:graph) {
            if (!indegree.containsKey(node)){
                queue.offer(node);
                results.add(node);
                break;
            }
        }

        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    results.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return results;
    }
}
