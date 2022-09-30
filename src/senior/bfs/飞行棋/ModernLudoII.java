package senior.bfs.飞行棋;

import java.util.*;

/**
 * 1565 · 飞行棋 I
 *
 * https://www.lintcode.com/problem/1565/?fromId=178&_from=collection
 *
 * 描述
 * 有一个一维的棋盘，起点在棋盘的最左侧，终点在棋盘的最右侧，棋盘上有几个位置是跟其他的位置相连的，即如果A与B相连，
 * 则当棋子落在位置A时, 你可以选择是否不投骰子，直接移动棋子从A到B。并且这个连接是单向的，即不能从B移动到A，
 * 现在给定这个棋盘的长度length和位置的相连情况connections，你有一个六面的骰子(点数1-6)，最少需要丢几次才能到达终点。
 *
 *
 * 下标从 1 开始
 * length > 1
 * 起点不与任何其他位置连接
 * connections[i][0] < connections[i][1]
 *
 * 输入: length = 15 和 connections = [[2, 8],
 * [6, 9]]
 * 输出: 2
 * 解释:
 * 1->6 (投骰子)
 * 6->9 (直接相连)
 * 9->15(投骰子)
 *
 * DP算法。
 */
public class ModernLudoII {

    public int modernLudo(int length, int[][] connections) {
        Map<Integer, Set<Integer>> graph = buildGraph(length, connections);
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        distance.put(1, 0);
        for (int i = 2; i <= length; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (distance.get(neighbor) > distance.get(node)) {
                    distance.put(neighbor, distance.get(node));
                    queue.offer(neighbor);
                }
            }

            int limit = Math.min(node + 7, length + 1);
            for (int i = 1; i < limit; i++) {
                Integer nextNode = node + i;
                if (distance.get(nextNode) > distance.get(node) + 1) {
                    distance.put(nextNode, distance.get(node) + 1);
                    queue.offer(nextNode);
                }
            }
        }
        return distance.get(length);
    }


    //构图
    private Map<Integer, Set<Integer>> buildGraph(int length, int[][] connections){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int[] connection = connections[i];
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(to);
        }
        return graph;
    }
}
