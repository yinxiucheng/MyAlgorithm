package junior.dp.coordinate;

/**
 * 115 · 不同的路径 II
 *
 * https://www.lintcode.com/problem/115/
 *
 * 描述
 * "不同的路径" 的跟进问题：
 * 有一个机器人的位于一个 m × n m×n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 *
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 */
public class UniquePaths {

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || obstacleGrid.length == 0){
            return 0;
        }
        if (null == obstacleGrid[0] || obstacleGrid[0].length == 0){
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        // # dp state 表示走到 （i，j）位置 路径数。
        int[][] dp = new int[n][m];

        //initialize
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }


}
