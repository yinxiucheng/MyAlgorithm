package senior.bfs.邮局;

import java.util.*;

/**
 * 574 · 邮局的建立
 *
 * https://www.lintcode.com/problem/574/?fromId=178&_from=collection
 *
 * 描述
 * 给出一个二维的网格，每一个格子上用 1 表示房子，0 表示空。要求在网格中，找到一个空地建立邮局，
 * 使得邮局到所有的房子的距离和最小。返回所有房子到邮局的最小距离和，如果不可能建邮局则返回-1。
 *
 * 你可以穿越房子和空地
 * 你只能在空地建立邮局。
 * 房子跟邮局之间的距离为曼哈顿距离
 *
 */
public class ShortestDistance {

    final int TYPE_EMPTY = 0;
    final int TYPE_HOUSE = 1;

    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> emptySet = new HashSet<>();
        Set<Integer> houseSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == TYPE_EMPTY) {
                    emptySet.add(hash(i, j, m));
                } else {
                    houseSet.add(hash(i, j, m));
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (Integer emptyId: emptySet) {
            int x = emptyId / m;
            int y = emptyId % m;
            int curDistance = bfs(x, y, grid, houseSet);
            System.out.println("the x:" + x + ", the y:" + y + ", distance:" + curDistance);
            minDistance = Math.min(minDistance, curDistance);
        }
        return minDistance;
    }

    final int[][] DIRECTIONS = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    private int bfs(int x, int y, int[][] grid, Set<Integer> houseSet){
        int resultDistance = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> distance = new HashMap<>();
        int id = hash(x, y, m);
        queue.offer(id);
        distance.put(id, 0);
        Set<Integer> visitedHouse = new HashSet<>();

        while (!queue.isEmpty()){
            int curId = queue.poll();
            int curX = curId / m;
            int curY = curId % m;
            for (int[] direction: DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (!isInRange(newX, newY, grid)){
                    continue;
                }
                int newId = hash(newX, newY, m);
                if (!distance.containsKey(newId)){
                    int curDistance = distance.get(curId) + 1;
                    distance.put(newId, curDistance);
                    if (grid[newX][newY] == TYPE_HOUSE){
                        resultDistance += curDistance;
                        visitedHouse.add(newId);
                    }
                    queue.offer(newId);
                }
            }
        }
        if (visitedHouse.size() < houseSet.size()){
            return Integer.MAX_VALUE;
        }
        return resultDistance;
    }

    private boolean isInRange(int x, int y, int[][] grid){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        return true;
    }

    private int hash(int x, int y, int m){
        return x * m + y;
    }
}
