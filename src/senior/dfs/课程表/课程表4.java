package senior.dfs.课程表;

import java.util.*;

/**
 * 815 · 课程表IV
 *
 * https://www.lintcode.com/problem/815/?fromId=178&_from=collection
 *
 * 描述
 * 总共有n个课程，从0到n-1。有些课程可能有先决条件，例如，你想修课程0，你必须先修一门课程1，这两门课之间的关系表示为:[0,1]
 * 考虑到课程的总数和先决条件对的列表，返回你可以得到所有课程的不同方法的数量。
 *
 * 输入:
 * n = 2
 * prerequisites = [[1,0]]
 * 输出: 1
 * 说明:
 * 你必须按照0->1的顺序上课。
 *
 */
public class 课程表4 {

    public int topologicalSortNumber(int n, int[][] p) {
        int[] inDegree = new int[n];
        Map<Integer, Set<Integer>> graph = buildGraph(n, p, inDegree);
        int[] result = {0};
        boolean[] visited = new boolean[n];
        dfs(0, graph, inDegree, visited, result);
        return result[0];
    }

    private void dfs(int level , Map<Integer, Set<Integer>> graph, int[] inDegree, boolean[] visited, int[] result){
        if (level == graph.size()){
            result[0] ++;
            return;
        }
        List<Integer> zeroDegreeList = getZeroDegree(inDegree, visited);
        for (Integer node: zeroDegreeList) {
            visited[node] = true;
            for (Integer neighbor: graph.get(node)) {
                inDegree[neighbor] --;
            }
            dfs(level + 1, graph, inDegree, visited, result);
            for (Integer neighbor: graph.get(node)) {
                inDegree[neighbor] ++;
            }
            visited[node] = false;
        }
    }

    private List<Integer> getZeroDegree(int[] inDegree, boolean[] visited){
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && !visited[i]){
                results.add(i);
            }
        }
        return results;
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] p, int[] inDegree){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] item : p) {
            graph.get(item[1]).add(item[0]);
            inDegree[item[0]] ++;
        }
        return graph;
    }

}
