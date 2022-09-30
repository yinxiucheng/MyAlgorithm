package senior.dfs.tree;

import java.util.*;

/**
 * 1469 · 树上最长路径
 *
 * https://www.lintcode.com/problem/1469/solution/18645
 *
 *
 */
public class 树上的最长路径 {



    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
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
        int[] maxChainPath = dfs(graph, 0, -1);
        return maxChainPath[1];
    }

    private int[] dfs(Map<Integer, Set<Pair>> graph, int node, int parent){
        int maxChain = 0;
        int maxPath = 0;

        int child_longest_chain = 0;
        int child_second_chain = 0;

        Set<Pair> neighbors = graph.get(node);
        for (Pair neighbor : neighbors) {
            if (neighbor.end == parent){
                continue;
            }
            int[] childMaxChainPath = dfs(graph, neighbor.end, node);
            //求出当前的 chain。
            int curChain = childMaxChainPath[0] + neighbor.val;

            maxChain = Math.max(maxChain, curChain);
            maxPath = Math.max(maxPath, childMaxChainPath[1]);
            // 求出所有chain 中 第一、第二的 chain。
            int[] firstSecond = getFirstSecond(child_longest_chain, child_second_chain, curChain);
            // 最长路径就是 在 最长路径 跟 第一、第二chain的和 两者中间取最大值。
            maxPath = Math.max(maxPath, firstSecond[0] + firstSecond[1]);
        }
        return new int[]{maxChain, maxPath};
    }

    private int[] getFirstSecond(int first, int second, int third){
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        Collections.sort(list);
        return new int[]{list.get(2), list.get(1)};
    }

    class Pair{
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
