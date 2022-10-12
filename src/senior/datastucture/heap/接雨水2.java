package senior.datastucture.heap;

import java.util.*;

/**
 * 364 · 接雨水 II
 *
 * https://www.lintcode.com/problem/364/solution/18267?fromId=178&_from=collection
 *
 */
public class 接雨水2 {
    public static void main(String[] args) {
        int[][] heights = {{12,13,0,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        trapRainWater(heights);
    }

    public static int trapRainWater(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Comparator<Cell> comparator = Comparator.comparingInt(o -> o.height);
        Queue<Cell> queue = new PriorityQueue<>(comparator);
        Set<Integer> visitedSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int index1 = hash(i, 0, m);
            int index2 = hash(i, m - 1, m);
            queue.offer(new Cell(index1, heights[i][0]));
            queue.offer(new Cell(index2, heights[i][m-1]));
            visitedSet.add(index1);
            visitedSet.add(index2);
        }

        for (int j = 0; j < m; j++) {
            int index1 = hash(0, j, m);
            int index2 = hash(n-1, j, m);
            queue.offer(new Cell(index1, heights[0][j]));
            queue.offer(new Cell(index2, heights[n-1][j]));
            visitedSet.add(index1);
            visitedSet.add(index2);
        }
        int water = 0;
        while (!queue.isEmpty()){
           Cell curCell = queue.poll();
            for (int[] direction: DIRECTIONS) {
                int[] point = deHash(curCell.index, m);
                int newX = point[0] + direction[0];
                int newY = point[1] + direction[1];
                if (!isInvalid(newX, newY, n, m, visitedSet)){
                    continue;
                }
                int newHeight = heights[newX][newY];
                int newIndex = hash(newX, newY, m);
                visitedSet.add(newIndex);
                queue.offer(new Cell(newIndex, Math.max(curCell.height, newHeight)));
                water += Math.max(0, curCell.height - newHeight);
            }
            if (visitedSet.size() == n * m){
                break;
            }
        }
        return water;
    }

    private static boolean isInvalid(int x, int y, int n, int m, Set<Integer> visited){
        if (x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }
        int index = hash(x, y, m);
        if (visited.contains(index)){
            return false;
        }
        return true;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int hash(int x, int y, int m){
        return x * m + y;
    }

    private static int[] deHash(int index, int m){
        int x = index / m;
        int y = index % m;
        return new int[]{x, y};
    }

   static class Cell{
        int index;
        int height;
        public Cell(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
}
