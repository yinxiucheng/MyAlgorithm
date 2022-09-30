package junior.bfs.shortpath;

import junior.datamodel.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/611/solution/32805
 *  使用双向 宽度优先搜索
 */
public class ShortestPath1 {
    int[] dx = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
    int[] dy = new int[]{2, -2, 1, -1, 2, -2, 1, -1};

    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (null == grid || grid.length == 0){
            return -1;
        }
        if (null == grid[0] || grid[0].length == 0){
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y){
            return 0;
        }

        if (grid[destination.x][destination.y]){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        boolean[][] forwardVisitSet = new boolean[n][m];
        boolean[][] backwardVisitSet = new boolean[n][m];
        forwardQueue.offer(source);
        backwardQueue.offer(destination);
        forwardVisitSet[source.x][source.y] = true;
        backwardVisitSet[destination.x][destination.y] = true;
        int distance = 0;

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()){
            distance ++ ;
            if (extendQueue(grid, forwardQueue, forwardVisitSet, backwardVisitSet)){
                return distance;
            }
            distance ++;
            if (extendQueue(grid, backwardQueue, backwardVisitSet, forwardVisitSet)){
                return distance;
            }

        }
        return -1;
    }

    private boolean extendQueue(boolean[][] grid, Queue<Point> queue, boolean[][] visited, boolean[][] oppositeVisited){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point point = queue.poll();
            for (int j = 0; j < 8; j++) {
                Point newPoint = new Point(point.x + dx[j], point.y + dy[j]);
                if (!isValid(grid, newPoint)){
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

    // 越界了，或者访问过了。
    private boolean isValid(boolean[][] grid, Point point){
        if (point.x < 0 || point.x >= grid.length){
            return false;
        }

        if (point.y < 0 || point.y >= grid[0].length){
            return false;
        }
        if (grid[point.x][point.y]){
            return false;
        }
        return true;
    }
}
