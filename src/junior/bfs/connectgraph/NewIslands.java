package junior.bfs.connectgraph;

import junior.datamodel.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 433 · 岛屿的个数
 *
 * https://www.lintcode.com/problem/433/description?fromId=161&_from=collection
 */
public class NewIslands {

   static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{
                {true, true, false, false, false},
                {false, true, false, false, true},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, true}
        };
        int result = numIslands(grid);
        System.out.println("result is " + result);

    }


    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int numIslands(boolean[][] grid) {
        if (null == grid || grid.length == 0){
            return 0;
        }
        if (null == grid[0] || grid[0].length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]){
                    bfs(grid, new Point(i, j));
                    num ++;
                }
            }
        }
        return num;
    }

    private static void bfs(boolean[][] grid, Point point){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        grid[point.x][point.y] = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point source = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Point newPoint = new Point(source.x + DIRECTIONS[j][0], source.y + DIRECTIONS[j][1]);
                    if (!isValid(grid, newPoint)){
                        continue;
                    }
                    grid[newPoint.x][newPoint.y] = false;
                    queue.offer(newPoint);
                }
            }
        }
    }

    private static boolean isValid(boolean[][] grid, Point point){
        if (point.x < 0 || point.x >= grid.length){
            return false;
        }
        if (point.y < 0 || point.y >= grid[0].length){
            return false;
        }
        return grid[point.x][point.y];
    }
}
