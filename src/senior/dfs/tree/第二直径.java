package senior.dfs.tree;

import java.util.*;

/**
 * 291 · 第二直径
 *
 * https://www.lintcode.com/problem/291/solution/54658?fromId=178&_from=collection
 *
 * 描述
 * 给出由n个结点，n−1条边组成的一棵树。求这棵树的第二直径，也就是两两点对之间距离的次大值。
 * 给出大小为(n-1) \times 3(n−1)×3的数组edge,edge[i][0],edge[i][1],edge[i][2],表示第i条边是从edge[i][0]连向edge[i][1]，长度为edge[i][2]的无向边。
 *
 */
public class 第二直径 {

    public long getSecondDiameter(int[][] edge) {
        int n = edge.length;
        Map<Integer, Set<Pair>> graph = buildGraph(n + 1, edge);
        //连续做三次bfs.
        Pair pair1 = bfs(0, graph);
        Pair pair2 = bfs(pair1.point, graph);// pair2, 第一次的第二距离。
        Pair pair3 = bfs(pair2.point, graph);// pair3.val 第二次的第二距离
        return Math.max(pair2.val, pair3.val);// 求出 前两个的第二距离的 最大值即可。
    }

    //bfs 返回 最大距离 的 nodeId, 以及第二距离的 距离值。
    private Pair bfs(int root, Map<Integer, Set<Pair>> graph){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        Map<Integer, Long> distanceToRoot = new HashMap<>();
        distanceToRoot.put(root, 0L);

        int nodeFirst = root, nodeSecond = root;
        while (!queue.isEmpty()){
            int curNode = queue.poll();

            Set<Pair> neighbors = graph.get(curNode);
            for (Pair neighbor: neighbors) {
                if (distanceToRoot.containsKey(neighbor.point)){
                    continue;
                }
                long distance = distanceToRoot.get(curNode) + neighbor.val;
                if (distance > distanceToRoot.get(nodeFirst)){
                    nodeSecond = nodeFirst;
                    nodeFirst = neighbor.point;
                }else if (distance > distanceToRoot.get(nodeSecond)){
                    nodeSecond = neighbor.point;
                }
                distanceToRoot.put(neighbor.point, distance);
                queue.offer(neighbor.point);
            }
        }
        return new Pair(nodeFirst, distanceToRoot.get(nodeSecond));
    }

    private Map<Integer, Set<Pair>> buildGraph(int n, int[][] edge){
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] item : edge) {
            graph.get(item[0]).add(new Pair(item[1], item[2]));
            graph.get(item[1]).add(new Pair(item[0], item[2]));
        }
        return graph;
    }

    class Pair{
        int point;
        long val;
        public Pair(int end, long val){
            this.point = end;
            this.val = val;
        }
    }

}
