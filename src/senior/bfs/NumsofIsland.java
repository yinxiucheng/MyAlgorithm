package senior.bfs;

import junior.datamodel.Point;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 677 · 大岛的数量
 *
 * https://www.lintcode.com/problem/677/?fromId=178&_from=collection
 *
 * 描述
 * 给一个布尔类型的二维数组, 0 表示海, 1 表示岛。如果两个1是相邻的,那么我们认为他们是同一个岛.我们只考虑 上下左右 相邻.
 * 找到大小在 k 及 k 以上的岛屿的数量
 *
 *
 *
 */
public class NumsofIsland {

    final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numsofIsland(boolean[][] grid, int k) {
        if (null == grid || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]){//缺点，这里修改了 grid 原数组，最好是不要修改。
                    int sizeOfIsland = bfs(grid, new Point(i, j));
                    if (sizeOfIsland >= k){
                        nums ++;
                    }
                }
            }
        }
        return nums;
    }

    private int bfs(boolean[][] grid, Point point){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(point);
        grid[point.x][point.y] = false;
        int sizeOfIsLands = 0;
        while (!queue.isEmpty()){
           Point curPoint =  queue.poll();
            sizeOfIsLands ++ ;
            for (int i = 0; i < 4; i++) {
                int newX = curPoint.x + directions[i][0];
                int newY = curPoint.y + directions[i][1];
                if (!isValid(newX, newY, grid)){
                    continue;
                }
                queue.offer(new Point(newX, newY));
                grid[newX][newY] = false;
            }
        }
        return sizeOfIsLands;
    }

    private boolean isValid(int x, int y, boolean[][] grid){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        return grid[x][y];
    }

}
