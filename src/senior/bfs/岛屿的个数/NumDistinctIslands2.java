package senior.bfs.岛屿的个数;

import junior.datamodel.Point;

import java.util.*;

/**
 * 804 · 不同岛屿的数量II
 *
 * https://www.lintcode.com/problem/804/?fromId=178&_from=collection
 *
 * 描述
 * 给定一个0和1的非空的二维数组网格，一个岛是一个1(表示陆地)的组，4个方向(水平或垂直)连接。你可以假设网格的所有四条边都被水包围。
 * 计算不同岛屿的数量。当一个岛被认为与另一个岛相同时，它们有相同的形状，或在旋转后的形状相同(90,180，或270度)或翻转(左/右方向或向上/向下方向)。
 *
 *
 */
public class NumDistinctIslands2 {

    public int numDistinctIslands2(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       boolean[][] visited = new boolean[n][m];
       Set<String> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (grid[i][j] == 1 && !visited[i][j]){
                    String island = bfs(i, j, grid, visited);
                    if (!island.isEmpty()){
                        islands.add(island);
                    }
                }
            }
        }
        return islands.size();
    }

    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private String bfs(int x, int y, int[][] grid, boolean[][] visited){
        Point original = new Point(x, y);
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(original);
        visited[x][y] = true;

        List<Point> path = new ArrayList<>();
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            path.add(curPoint);
            for (int[] direction: DIRECTIONS) {
                int newX = curPoint.x + direction[0];
                int newY = curPoint.y + direction[1];
                if (!isValid(newX, newY, grid, visited)){
                    continue;
                }
                visited[newX][newY] = true;
                Point newPoint = new Point(newX, newY);
                queue.offer(newPoint);
            }
        }
        return transform(path);
    }

    private String transform(List<Point> originalPath){
        if (originalPath.size() == 0){
            return "";
        }
        List<String> islands = new ArrayList<>();
        int[][] transList = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int[] trans: transList) {
            List<Point> changeList1 = new ArrayList<>();
            List<Point> changeList2 = new ArrayList<>();
            for (Point point: originalPath) {
                Point newPoint1 = new Point(point.x * trans[0], point.y * trans[1]);
                changeList1.add(newPoint1);
                Point newPoint2 = new Point(point.y * trans[0], point.x * trans[1]);
                changeList2.add(newPoint2);
            }
            islands.add(getStr(changeList1));
            islands.add(getStr(changeList2));
        }
        Collections.sort(islands);
        return islands.get(0);
    }

    private String getStr(List<Point> path){
        Collections.sort(path, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = o1.x - o2.x;
                if (diff == 0){
                    diff = o1.y - o2.y;
                }
                return diff;
            }
        });

        int dx = path.get(0).x, dy = path.get(0).y;
        StringBuilder builder = new StringBuilder();
        for (Point point: path) {
            point.x -= dx;
            point.y -= dy;
            builder.append(point.x).append(",").append(point.y);
        }
        return builder.toString();
    }



    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        if (grid[x][y] == 0){
            return false;
        }
        return !visited[x][y];
    }

}
