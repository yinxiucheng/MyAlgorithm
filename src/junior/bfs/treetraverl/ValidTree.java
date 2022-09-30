package junior.bfs.treetraverl;

import java.util.*;

/**
 * 178 · 图是否是树
 *
 * https://www.lintcode.com/problem/178/
 *
 * 描述
 * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点), 写一个函数去判断这张｀无向｀图是否是一棵树
 *
 */
public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (null == edges){
            return false;
        }
        if (edges.length != n - 1){// 顶点数是 边数 + 1
            return false;
        }

        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> duplicate = new HashSet<>();
        queue.offer(0);
        duplicate.add(0);
        while (!queue.isEmpty()){
            Integer point = queue.poll();
            for (Integer neighbor: graph.get(point)) {
                if (!duplicate.contains(neighbor)){
                    queue.offer(neighbor);
                    duplicate.add(neighbor);
                }
            }
        }
        return duplicate.size() == n;
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
