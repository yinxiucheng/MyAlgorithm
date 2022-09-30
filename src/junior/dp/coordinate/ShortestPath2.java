package junior.dp.coordinate;

/**
 * 630 · 骑士的最短路径II
 *
 * https://www.lintcode.com/problem/630/solution?fromId=161&_from=collection
 *
 * 描述
 * 在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，骑士的初始位置是 (0, 0) ，他想要达到 (n - 1, m - 1) 这个位置，
 * 骑士只能从左边走到右边。找出骑士到目标位置所需要走的最短路径并返回其长度，如果骑士无法达到则返回 -1.
 *
 */
public class ShortestPath2 {

    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = new int[][]{
                {1, -2},
                {-1, -2},
                {-2, -1},
                {2, -1}
        };

        // # 跳转到 当前位置需要的步数。
        int[][] dp = new int[n][m];

        //initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j]){
                    continue;
                }
                for (int k = 0; k < directions.length; k++) {
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if (!isValid(x, y, grid)){
                        continue;
                    }
                    if (dp[x][y] == Integer.MAX_VALUE){// 一定要先走过了 （x, y）点后才能继续往下走。
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
                }
            }
        }

        if (dp[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[n-1][m-1];
    }

    private boolean isValid(int x, int y, boolean[][] grid){
        if (x < 0 || x >= grid.length){
            return false;
        }

        if (y < 0 || y >= grid[0].length){
            return false;
        }
        return true;// todo grid 值对么。
    }
}
