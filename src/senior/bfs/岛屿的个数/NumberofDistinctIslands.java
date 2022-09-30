package senior.bfs.岛屿的个数;

import junior.datamodel.Point;

import java.util.*;

/**
 * 860 · 不同岛屿的个数
 *
 * https://www.lintcode.com/problem/860/?fromId=178&_from=collection
 *
 *
 * 给定一个由0和1组成的非空的二维网格，一个岛屿是指四个方向（包括横向和纵向）都相连的一组1（1表示陆地）。你可以假设网格的四个边缘都被水包围。
 *
 * 找出所有不同的岛屿的个数。如果一个岛屿与另一个岛屿形状相同（不考虑旋转和翻折），我们认为这两个岛屿是相同的。
 */
public class NumberofDistinctIslands {

    public int numberofDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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

    final int[][] DIRECTIONS = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    private String bfs(int x, int y, int[][] grid, boolean[][] visited){
        List<Point> path = new ArrayList<>();
        Point original = new Point(x, y);
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(original);
        visited[x][y] = true;

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

    private String transform(List<Point> path){
        if (path.size() == 0){
            return "";
        }
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
        for (Point point : path) {
            point.x -= dx;
            point.y -= dy;
            builder.append("(").append(point.x).append(",").append(point.y).append(")");
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
        return !visited[x][y];//没有访问过。
    }
}
