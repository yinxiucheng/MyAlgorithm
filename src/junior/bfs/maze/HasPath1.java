package junior.bfs.maze;

import junior.datamodel.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 787 · 迷宫
 * https://www.lintcode.com/problem/787/?fromId=161&_from=collection
 *
 * 描述
 * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，
 * 但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 *
 * 给定球的起始位置，目的地和迷宫，确定球是否可以停在终点。
 *
 * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 */
public class HasPath1 {

    static final int[][] DIRECTIONS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };


    //[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
    //[0,4]
    //[3,2]
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0, 4};
        int[] destination = {3, 2};
        boolean hasPathFlag = hasPath(maze, start, destination);
        System.out.println("hasPath " + hasPathFlag);
    }

    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (null == maze || maze.length == 0){
            return false;
        }
        if (null == maze[0] || maze[0].length == 0){
            return false;
        }
        Queue<Point> queue = new LinkedList<>();
        Point source = new Point(start[0], start[1]);
        Point direction = new Point(destination[0], destination[1]);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(source);
        visited[source.x][source.y] = true;
        while (!queue.isEmpty()){
            Point point = queue.poll();
            if (point.x == direction.x && point.y == direction.y){
                return true;
            }
            for (int j = 0; j < DIRECTIONS.length; j++) {
                Point newPoint = new Point(point.x + DIRECTIONS[j][0], point.y + DIRECTIONS[j][1]);
                Point prePoint = point;
                while (isValid(maze, newPoint)){//只能朝着一个方向滚动，撞墙或者碰到障碍。
                    prePoint = newPoint;
                    newPoint = new Point(newPoint.x + DIRECTIONS[j][0], newPoint.y + DIRECTIONS[j][1]);
                }
                if (!visited[prePoint.x][prePoint.y]){
                    queue.offer(prePoint);
                    visited[prePoint.x][prePoint.y] = true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] maze, Point point){
        if (point.x < 0 || point.x >= maze.length){
            return false;
        }
        if (point.y < 0 || point.y >= maze[0].length){
            return false;
        }
        if (maze[point.x][point.y] == 1){
            return false;
        }
        return true;
    }
}
