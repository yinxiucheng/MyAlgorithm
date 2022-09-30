package senior.dfs.tree;

import java.util.*;

/**
 * 1469 · 树上最长路径
 *
 * https://www.lintcode.com/problem/1469/solution/18645
 *
 *  两次BFS
 */
public class 树上的最长路径2 {

    public static void main(String[] args) {
      int[] start = {0,0,2,2};
      int[] ends = {1,2,3,4};
      int[] lens = {1,2,5,6};

      int result = longestPath(5, start, ends, lens);
      System.out.println("the result is " + result);
    }

    public static int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i];
            int end = ends[i];
            int len = lens[i];

            graph.get(start).add(new Pair(end, len));
            graph.get(end).add(new Pair(start, len));
        }
        int[] pointWeight = bfs(0, graph);
        int[] endAns = bfs(pointWeight[0], graph);
        return endAns[1];
    }

    private static int[] bfs(int root, Map<Integer, Set<Pair>> graph){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        Map<Integer, Integer> distanceToRoot = new HashMap<>();
        distanceToRoot.put(root, 0);
        int maxPoint = -1;
        int maxWeight = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int curNode = queue.poll();
            if (distanceToRoot.get(curNode) > maxWeight){
                maxWeight = distanceToRoot.get(curNode);
                maxPoint = curNode;
            }
            Set<Pair>  neighbors = graph.get(curNode);
            for (Pair neighbor: neighbors) {
                if (distanceToRoot.containsKey(neighbor.end)){
                    continue;
                }
                queue.offer(neighbor.end);
                distanceToRoot.put(neighbor.end, distanceToRoot.get(curNode) + neighbor.val);
            }
        }
        return new int[]{maxPoint, maxWeight};
    }


    public static class Pair{
        int end;
        int val;
        public Pair(int end, int val){
            this.end = end;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return end == pair.end && val == pair.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(end, val);
        }
    }
}
