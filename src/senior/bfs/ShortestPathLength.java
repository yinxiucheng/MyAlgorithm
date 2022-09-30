package senior.bfs;

import java.util.*;

/**
 * 1422 · 访问所有节点的最短路径
 *
 * https://www.lintcode.com/problem/1422/description?fromId=178&_from=collection
 *
 * 描述
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 */
public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        Queue<PointState> queue = new ArrayDeque<>();
        Map<PointState, Integer> distance = new HashMap<>();

        int k = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            PointState state = new PointState(i, 1 << i);
            queue.offer(state);
            distance.put(state, 0);
        }

        while (!queue.isEmpty()){
            PointState curState = queue.poll();
            int curId = curState.id, curVisited = curState.visited;
            if (curVisited == k ){
                return distance.get(curState);
            }
            for (int neighborId: graph[curId]) {
                int neighborVisited = curVisited | 1 << neighborId;
                PointState neighborState = new PointState(neighborId, neighborVisited);
                if (distance.containsKey(neighborState)){
                    continue;
                }
                distance.put(neighborState, distance.get(curState) + 1);
                queue.offer(neighborState);
            }
        }
        return 0;
    }

    class PointState{
        int id;
        int visited;
        public PointState(int id, int visited){
            this.id = id;
            this.visited = visited;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointState that = (PointState) o;
            return id == that.id && visited == that.visited;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, visited);
        }
    }


}
