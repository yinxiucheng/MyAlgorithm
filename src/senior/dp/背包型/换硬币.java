package senior.dp.背包型;

/**
 * 669 · 换硬币
 * https://www.lintcode.com/course/24/learn/669?chapterId=138&sectionId=943&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量. 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 *
 * 输入：
 * [1, 2, 5]
 * 11
 * 输出： 3
 * 解释： 11 = 5 + 5 + 1
 */
public class 换硬币 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];//dp[i][j] 为 前i枚硬币凑出总金额为j时的硬币数。

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1] && dp[i][j-coins[i-1]] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }

        return dp[n][amount]==Integer.MAX_VALUE ? -1: dp[n][amount];
    }
}
