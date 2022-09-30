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
 *
 * 双向BFS搜索
 */
public class ShortestPath3 {

    int[][] DIRECTIONS = new int[][]{{1, 2},{1, -2},{2, 1},{2, -1}};
    int[][] OPPOSITE_DIRECTIONS = new int[][]{{-1, 2},{-1, -2},{-2, 1},{-2, -1}};

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
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] forwardVisited = new boolean[n][m];
        boolean[][] backwardVisited = new boolean[n][m];

        Point source = new Point(0, 0);
        Point direction = new Point(n-1, m-1);
        forwardVisited[source.x][source.y] = true;
        backwardVisited[direction.x][direction.y] = true;
        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();

        forwardQueue.offer(source);
        backwardQueue.offer(direction);
        int distance = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()){
            distance++;
            if (enteredQueue(grid, forwardQueue, forwardVisited, backwardVisited, DIRECTIONS)){
                return distance;
            }

            distance++;
            if (enteredQueue(grid, backwardQueue, backwardVisited, backwardVisited, OPPOSITE_DIRECTIONS)){
                return distance;
            }
        }
        return -1;
    }

    private boolean enteredQueue(boolean[][] grid, Queue<Point> queue, boolean[][] visited, boolean[][] oppositeVisited, int[][] direction){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point point = queue.poll();
            for (int j = 0; j < direction.length; j++) {
                Point newPoint = new Point(point.x + direction[j][0], point.y + direction[j][1]);
                if (!isValid(grid, newPoint, visited)) {
                    continue;
                }
                if (oppositeVisited[newPoint.x][newPoint.y]){
                    return true;
                }
                queue.offer(newPoint);
                visited[newPoint.x][newPoint.y] = true;
            }
        }
        return false;
    }

    private boolean isValid(boolean[][] grid, Point point, boolean[][] visited) {
        if (point.x < 0 || point.x >= grid.length) {
            return false;
        }

        if (point.y < 0 || point.y >= grid[0].length) {
            return false;
        }

        if (visited[point.x][point.y]) {
            return false;
        }

        if (visited[point.x][point.y]) {
            return false;
        }
        return true;
    }

}
