package junior.bfs.maze;

import java.util.*;

/**
 * 788 · 迷宫II
 * <p>
 * https://www.lintcode.com/problem/788/description
 * 描述
 * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
 * <p>
 * 给定球的起始位置，目标和迷宫，找到最短距离的球在终点停留。距离是由球从起始位置(被排除)到目的地(包括)所走过的空空间的数量来定义的。如果球不能停在目的地，返回-1。
 * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
 */
public class MazeI {

    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    // write your code here
    int[] dx = {0, 0, -1, 1};

    int[] dy = {1, -1, 0, 0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        // write your code here

        int m = maze.length;

        int n = maze[0].length;

        PriorityQueue<Posn> q = new PriorityQueue<Posn>((p1, p2) -> (p1.len - p2.len));

        q.offer(new Posn(start[0], start[1], 0));

        boolean[][] visit = new boolean[m][n];

        while (!q.isEmpty()) {


            Posn cur = q.poll();

            int x = cur.x;

            int y = cur.y;

            if (x == destination[0] && y == destination[1]) {

                return cur.len;

            }

            if (visit[x][y]) {

                continue;

            }

            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {

                int nx = x;

                int ny = y;

                int len = cur.len;

                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {

                    nx += dx[i];

                    ny += dy[i];

                    len++;

                }

                len--;

                nx -= dx[i];

                ny -= dy[i];

                q.offer(new Posn(nx, ny, len));


            }

        }

        return -1;

    }

}

class Posn {

    int x;

    int y;

    int len;

    public Posn(int a, int b, int len) {

        x = a;

        y = b;

        this.len = len;

    }
}
