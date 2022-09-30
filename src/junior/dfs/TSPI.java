package junior.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/816/
 *
 * 描述
 * 给 n 个城市(从 1 到 n)，城市和无向道路成本之间的关系为3元组 [A, B, C]（在城市 A 和城市 B 之间有一条路，成本是 C）我们需要从1开始找到的旅行所有城市的付出最小的成本。
 */
public class TSPI {

    public static void main(String[] args) {
        int[][] roads =  new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 3}
        };

        int result = minCost(3, roads);
        System.out.print("the result is " + result);
    }

    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public static int minCost(int n, int[][] roads) {
       int[][] graph = createGraph(n, roads);
       Result result = new Result();
       Set<Integer> visited = new HashSet<>();
       List<Integer> path = new ArrayList<>();

       visited.add(1);
       path.add(1);

       dfs(1, n, visited, path,0, graph, result);
       return result.minCost;
    }

    /**
     * @param city  current city index
     * @param n  numbers of city
     * @param visited  visited city indexes
     * @param path  current path has visited
     * @param cost  reach the current city needs cost
     * @param graph  the graph of Points reach cost of all
     * @param result  the result contains the min cost.
     */
    private static void dfs(int city, int n, Set<Integer> visited, List<Integer> path, int cost, int[][] graph, Result result){
        if (visited.size() == n){
            result.minCost = Math.min(result.minCost, cost);
            return;
        }
        for (int nextCity = 0; nextCity < graph[city].length; nextCity++) {
            if (visited.contains(nextCity)){
                continue;
            }
            if (hasBetterPath(graph, path, nextCity)){
                continue;
            }
            visited.add(nextCity);
            path.add(nextCity);
            dfs(nextCity, n, visited, path,cost + graph[city][nextCity], graph, result);
            path.remove(path.size() - 1);
            visited.remove(nextCity);
        }
    }

    private static boolean hasBetterPath(int[][] graph, List<Integer> path, int nextCity){
        for (int i = 1; i < path.size(); i++) {
            int A = path.get(i - 1);
            int B = path.get(i);
            int last = path.get(path.size() - 1);
            if (graph[A][B] + graph[last][nextCity] > graph[A][last] + graph[B][nextCity]){
                return true;
            }
        }
        return false;
    }


    private static int[][] createGraph(int n, int[][] roads){
        int[][] graph = new int[n + 1][n + 1];//多开一行、一列，跟城市下标保持一致。
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int cost = roads[i][2];
            graph[a][b] = Math.min(graph[a][b], cost);
            graph[b][a] = Math.min(graph[b][a], cost);
        }
        return graph;
    }

   static class Result{
        int minCost;
        Result(){
            minCost = Integer.MAX_VALUE;
        }
    }
}
