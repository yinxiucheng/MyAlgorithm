package senior.bfs;

import junior.datamodel.Point;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 778 · 太平洋和大西洋的水流
 * https://www.lintcode.com/problem/778/?fromId=178&_from=collection
 *
 * 描述
 * 给定一个m×n的非负矩阵代表一个大洲，矩阵的每个单元格的值代表此处的地形高度，矩阵的左边缘和上边缘是“太平洋”，下边缘和右边缘是“大西洋”。
 *
 * 水流只能在四个方向（上，下，左或右）从一个单元格流向另一个海拔和自己相等或比自己低的单元格。
 *
 * 找到那些从此处出发的水既可以流到“太平洋”，又可以流向“大西洋”的单元格的坐标。
 *
 *
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            bfs(i, 0, matrix, pacific);
        }

        for (int j = 1; j < m; j++) {
            bfs(0, j, matrix, pacific);
        }

        for (int i = 0; i < n; i++) {
            bfs(i, m-1, matrix, atlantic);
        }

        for (int j = 1; j < m ; j++) {
            bfs(n-1, j, matrix, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void bfs(int x, int y, int[][] matrix, boolean[][] visited){
        if (visited[x][y]){
            return;
        }
        Point original = new Point(x, y);
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(original);
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            for (int[] direction: DIRECTIONS) {
                int newX = curPoint.x + direction[0];
                int newY = curPoint.y + direction[1];
                if (!isValid(newX, newY, matrix, visited)) {
                    continue;
                }
                if (matrix[curPoint.x][curPoint.y] <= matrix[newX][newY]){
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] matrix, boolean[][] visited){
        if (x < 0 || x >= matrix.length){
            return false;
        }

        if (y < 0 || y >= matrix[0].length){
            return false;
        }
        return !visited[x][y];
    }
}
