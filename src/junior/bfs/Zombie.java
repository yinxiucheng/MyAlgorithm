package junior.bfs;

import java.util.*;

/**
 * 598 · 僵尸矩阵
 *
 * https://www.lintcode.com/problem/598/
 *
 * 描述
 * 给一个二维网格，每一个格子都有一个值，2 代表墙，1 代表僵尸，0 代表人类(数字 0, 1, 2)。
 * 僵尸每天可以将上下左右最接近的人类感染成僵尸，但不能穿墙。将所有人类感染为僵尸需要多久，如果不能感染所有人则返回 -1。
 *
 *
 */
public class Zombie {

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,2,0,0},
                {1,0,0,2,1},
                {0,1,0,0,0}
        };

       int days =  zombie(grid);

    }

    public static int zombie(int[][] grid) {
        // 1. 遍历将 僵尸 1， 放入到 Set里。
        // queue 加入 set里的元素，
        // while 循环，遍历 每个queue.poll() 的邻近元素，为0 的改为1， 加入到 queue. level ++ 就是天数。
        // 出 while循环
        // 查看是否还有 人类存活。
        Set<Point> setZombie = new HashSet<>();
        Set<Point> setPeople = new HashSet<>();
        Set<Point> setWall = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];
                if (val == 0) {
                    setPeople.add(new Point(i, j, 0));
                } else if (val == 1) {
                    setZombie.add(new Point(i, j, 1));
                } else {
                    setWall.add(new Point(i, j, 2));
                }
            }
        }

        int[][] direction = new int[][]{
                {1, 0}, {-1, 0} , {0, 1}, {0, -1}
        };

        Queue<Point> queue = new LinkedList<>();
        for (Point point: setZombie) {
            queue.offer(point);
        }
        int days = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            days++;
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = curPoint.x + direction[j][0];
                    int y = curPoint.y + direction[j][1];
                    if (!isValid(x, y, grid)){
                        continue;
                    }
                    grid[x][y] = 1;
                    Point newZombie = new Point(x, y, 1);
                    setZombie.add(newZombie);
                    queue.offer(newZombie);
                }
                if (setZombie.size() + setWall.size() == n * m){
                    return days;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int[][] grid){
        if (x < 0 || x >= grid.length){
            return false;
        }

        if (y < 0 || y >= grid[0].length){
            return false;
        }

        if(grid[x][y] != 0){
            return false;
        }
        return true;
    }

    static class Point{
        int x;
        int y;
        int val;
        public Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && val == point.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, val);
        }
    }
}
