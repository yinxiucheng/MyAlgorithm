package junior.bfs.shortpath;

import junior.datamodel.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/630
 *
 * 描述
 * 在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，骑士的初始位置是 (0, 0) ，他想要达到 (n - 1, m - 1) 这个位置，骑士只能从左边走到右边。
 * 找出骑士到目标位置所需要走的最短路径并返回其长度，如果骑士无法达到则返回 -1.
 *
 * 骑士的最短路径的进阶版：
 */
public class ShortestPath2 {
    int[][] DIRECTIONS = new int[][]{{1,2}, {2, 1}, {1, -2}, {2, -1}};
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        if (null == grid || grid.length == 0){
            return -1;
        }
        if (null == grid[0] || grid[0].length == 0){
            return -1;
        }
        Point source = new Point(0, 0);
        int n = grid.length;
        int m = grid[0].length;
        Point direction = new Point(n-1, m-1);
        if (grid[direction.x][direction.y]){
            return -1;
        }
        boolean[][] visited = new boolean[n][m];
        visited[source.x][source.y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        if (source.x == direction.x && source.y == direction.y){
            return 0;
        }
        int distance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int j = 0; j < DIRECTIONS.length ; j++) {
                    Point newPoint = new Point(point.x + DIRECTIONS[j][0], point.y + DIRECTIONS[j][1]);
                    if (newPoint.x == direction.x && newPoint.y == direction.y){
                        return distance;
                    }
                    if (!isValid(grid, newPoint, visited)){
                        continue;
                    }
                    queue.offer(newPoint);
                    visited[newPoint.x][newPoint.y] = true;
                }
            }
            distance ++;
        }
        return  -1;
        // write your code here
    }

    private boolean isValid(boolean[][] grid, Point point, boolean[][] visited){
        if (point.x < 0 || point.x >= grid.length){
            return false;
        }

        if (point.y < 0 || point.y >= grid[0].length){
            return false;
        }
        if (grid[point.x][point.y]){
            return false;
        }
        if (visited[point.x][point.y]){
            return false;
        }
        return true;
    }

}
