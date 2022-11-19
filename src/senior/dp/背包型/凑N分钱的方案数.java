package senior.dp.背包型;

/**
 * 凑 N 分钱的方案数
 *
 * https://www.lintcode.com/problem/279/?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 */
public class 凑N分钱的方案数 {

    public int waysNCents(int n) {
        int[] coins = {1, 5, 10, 25};
        int len = coins.length;

        int[][] dp = new int[len + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <= n ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1]){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[len][n];
    }
}
