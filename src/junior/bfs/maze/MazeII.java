package junior.bfs.maze;

import junior.datamodel.Point;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 788 · 迷宫II
 *
 * https://www.lintcode.com/problem/788/description
 * 描述
 * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 *
 * 给定球的起始位置，目标和迷宫，找到最短距离的球在终点停留。距离是由球从起始位置(被排除)到目的地(包括)所走过的空空间的数量来定义的。如果球不能停在目的地，返回-1。
 * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 */
public class MazeII {

    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        Queue<Pair> queue = new LinkedList<>();
        Map<Point, Integer> mapDistance = new HashMap<>();
        Point startPoint = new Point(start[0], start[1]);
        Point destinationPoint = new Point(destination[0], destination[1]);

        queue.offer(new Pair(startPoint, 0));
        int[][] direction = {{1, 0},{0, 1},{-1, 0},{0, -1}};

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curPair = queue.poll();
                Point curPoint = curPair.point;
                if (curPoint == destinationPoint){
                    int minDistance = Math.min(curPair.distance, mapDistance.get(destinationPoint));
                    mapDistance.put(destinationPoint, minDistance);
                }
                for (int j = 0; j < 4; j++) {
                    int newPoint_x = curPoint.x + direction[j][0];
                    int newPoint_y = curPoint.y + direction[j][1];
                    int count = 0;
                    while (isValid(newPoint_x, newPoint_y, maze)){
                        newPoint_x +=  direction[j][0];
                        newPoint_y +=  direction[j][1];
                        count ++;
                    }
                    newPoint_x -=   direction[j][0];
                    newPoint_y -=  direction[j][1];
                    count--;
                    Point stopPoint = new Point(newPoint_x, newPoint_y);
                    int stopDistance = mapDistance.getOrDefault(stopPoint, Integer.MAX_VALUE);
                    int curTempDistance = curPair.distance + count;
                    if (stopDistance > curTempDistance){
                        mapDistance.put(stopPoint, curTempDistance);
                        queue.offer(new Pair(stopPoint, curTempDistance));
                    }
                }
            }
        }
        return mapDistance.getOrDefault(destinationPoint, Integer.MAX_VALUE);
    }

    private boolean isValid(int x, int y, int[][] maze){
        if (x < 0 || x >= maze.length){
            return false;
        }

        if (y < 0 || y >= maze[0].length){
            return false;
        }

        if (maze[x][y] == 1){
            return false;
        }
        return true;
    }

    class Pair{
        Point point;
        int distance;

        Pair(Point point, int distance){
            this.point = point;
            this.distance = distance;
        }
    }
}
