package senior.dp.坐标型;

/**
 * https://www.lintcode.com/problem/515/
 */
public class 房屋染色 {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        // 0, 红； 1 蓝； 2 绿；
        int[][] dp = new int[n][3];//定义状态
        for (int i = 0; i < 3; i++) {
            //初始化 第一座房子的 花费。
            dp[0][i] = costs[0][i];
        }

        // dp[i][0] = min{dp[i-1][1] + costs[i-1][1],  dp[i-1][2] + costs[i-1][2]};
        // dp[i][1] = min{dp[i-1][0] + costs[i-1][0], dp[i-1][2] + costs[i-1][2]};
        // dp[i][2] = min{dp[i-1][0] + costs[i-1][0], dp[i-1][1] + costs[i-1][1]};
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 0; k < 3; k++) {
                    if (k == j){
                        continue;
                    }
                    //dp[i - 1][k] 前一座房子的花费，颜色是K， 不同于j.
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                }
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
