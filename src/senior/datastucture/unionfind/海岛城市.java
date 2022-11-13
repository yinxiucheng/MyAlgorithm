package senior.datastucture.unionfind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/897/?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 * 897 · 海岛城市
 */
public class 海岛城市 {

    //BFS
    int[][] directions = {{1,0}, {0, 1}, {0, -1}, {-1, 0}};

    public int numIslandCities(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || visited[i][j]){
                    continue;
                }
                queue.offer(encode(i, j, m));
                visited[i][j] = true;
                boolean hasCity = false;
                while (!queue.isEmpty()){
                    int curIndex = queue.poll();
                    int x = curIndex/m;
                    int y = curIndex % m;
                    if (grid[x][y] == 2){
                        hasCity = true;
                    }
                    for (int k = 0; k < directions.length; k++) {
                        int newX = x + directions[k][0];
                        int newY = y + directions[k][1];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < m
                                && !visited[newX][newY]
                        && grid[newX][newY] != 0){
                            visited[newX][newY] = true;
                            queue.offer(encode(newX, newY, m));
                        }
                    }
                }
                if (hasCity){
                    result ++;
                }
            }
        }
        return result;
    }

    public int encode(int x, int y, int m){
       return x * m + y;
    }


}
