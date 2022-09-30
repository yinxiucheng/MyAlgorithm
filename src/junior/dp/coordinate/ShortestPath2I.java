package junior.dp.coordinate;

/**
 * 滚动数组
 *
 * 630 · 骑士的最短路径II
 *
 * https://www.lintcode.com/problem/630/solution?fromId=161&_from=collection
 *
 * 描述
 * 在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，骑士的初始位置是 (0, 0) ，他想要达到 (n - 1, m - 1) 这个位置，
 * 骑士只能从左边走到右边。找出骑士到目标位置所需要走的最短路径并返回其长度，如果骑士无法达到则返回 -1.
 *
 */
public class ShortestPath2I {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        if (null == grid || grid.length == 0){
            return -1;
        }
        if (null == grid[0] || grid[0].length == 0){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {
                {-1, -2},
                {1, -2},
                {2, -1},
                {-2, -1}
        };

        int[][] dp = new int[n][3];

        //初始化
        for (int i = 1; i < n; i++) { // 无法从 左边推算过来，得初始化。
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;

        for (int j = 1; j < m; j++) {// 这个地方不能 从 0 开始， dp[0][0] = 0 会被覆盖。
            for (int i = 0; i < n; i++) {
                dp[i][j%3] = Integer.MAX_VALUE;
                if (grid[i][j]){
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if (x < 0 || x >= n || y < 0 || y >= m){
                        continue;
                    }
                    if (dp[x][y%3] == Integer.MAX_VALUE){
                        continue;
                    }
                    dp[i][j%3] = Math.min(dp[i][j%3], dp[x][y%3] + 1);
                }
            }
        }

        if (dp[n-1][(m-1)%3] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[n-1][(m-1)%3];
    }
}
