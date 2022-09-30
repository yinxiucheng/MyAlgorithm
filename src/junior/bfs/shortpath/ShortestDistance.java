package junior.bfs.shortpath;

import junior.datamodel.Point;

import java.util.*;

/**
 * 573 · 邮局的建立 II
 *
 * https://www.lintcode.com/problem/573/
 *
 * 描述
 * 给出一个二维的网格，每一格可以代表墙 2 ，房子 1，以及空 0 (用数字0,1,2来表示)，在网格中找到一个位置去建立邮局，使得所有的房子到邮局的距离和是最小的。
 * 返回所有房子到邮局的最小距离和，如果没有地方建立邮局，则返回-1.
 *
 */
public class ShortestDistance {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0,0},
                {1,0,0,2,1},
                {0,1,0,0,0}};
       int result =  shortestDistance(grid);

    }

    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    private static final int TYPE_HOUSE = 1;
    private static final int TYPE_WALL = 2;
    private static final int TYPE_EMPTY = 0;

    public static int shortestDistance(int[][] grid) {
        Set<Point> houseSet = getType(TYPE_HOUSE, grid);
        Set<Point> emptySet = getType(TYPE_EMPTY, grid);

        int min = Integer.MAX_VALUE;
        for (Point empty: emptySet) {
            int currentDistance = bfs(empty, grid, houseSet);
            System.out.println("the current empty is Point(" + empty.x +"," + empty.y + ")");
            System.out.println("the current distance is " + currentDistance);
            min = Math.min(min, currentDistance);
        }
        System.out.println("the result is " + min);
//        bfs(new Point(1,1) , grid, houseSet);
        return min;
    }

    static int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    private static int bfs(Point original, int[][] grid, Set<Point> houseSet){
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Map<Point, Integer> distance = new HashMap<>();
        queue.offer(original);
        visited.add(original);
        int steps = 0;
        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            steps ++;
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = point.x + direction[j][0];
                    int newY = point.y + direction[j][1];
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 2){
                        continue;
                    }
                    Point newPoint = new Point(newX, newY);
                    if (visited.contains(newPoint)){
                        continue;
                    }
                    visited.add(newPoint);

                    if (grid[newX][newY] == 1){
                        sum += steps;
                        distance.put(newPoint, steps);
                        if (distance.size() == houseSet.size()){
                            return sum;
                        }
                        continue;
                    }
                    queue.offer(newPoint);
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    private static Set<Point> getType(int type, int[][] grid){
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == type){
                    pointSet.add(new Point(i, j));
                }
            }
        }
        return pointSet;
    }
}
