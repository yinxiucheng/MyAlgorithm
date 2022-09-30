package junior.bfs.shortpath;

import junior.datamodel.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 611 · 骑士的最短路线
 * https://www.lintcode.com/problem/611/solution/32805
 *
 */
public class ShortestPath {

    public static void main(String[] args) {
        // [[0,1,0],[0,0,1],[0,0,0]]
        boolean[][] grid = new boolean[][]{
                {false, true, false},
                {false, false, true},
                {false, false, false}
        };

        int result = shortestPath(grid, new Point(2, 0), new Point(2, 2));
        System.out.println("result is " + result);
    }

    /**
     * (x + 1, y + 2)
     * (x + 1, y - 2)
     * (x - 1, y + 2)
     * (x - 1, y - 2)
     * (x + 2, y + 1)
     * (x + 2, y - 1)
     * (x - 2, y + 1)
     * (x - 2, y - 1)
     */
    static int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public static int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        if (grid[destination.x][destination.y]) {
            return -1;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int distance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (null != point && point.x == destination.x && point.y == destination.y){
                    return distance;
                }
                for (int j = 0; j < 8; j++) {
                    Point newPoint = new Point(point.x + dx[j], point.y + dy[j]);
                    if (!isBound(grid, newPoint)){
                        continue;
                    }
                    queue.offer(newPoint);
                    grid[newPoint.x][newPoint.y] = true;
                }
            }
            distance++;
        }
        return -1;
    }

    private static boolean isBound(boolean[][] grid, Point point){
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
