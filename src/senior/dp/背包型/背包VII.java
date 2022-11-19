package senior.dp.背包型;

/**
 * 背包问题VII
 *
 * https://www.lintcode.com/course/24/learn/798/solution/17879?chapterId=141&sectionId=956&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 假设你身上有 n 元，超市里有多种大米可以选择，每种大米都是袋装的，必须整袋购买，给出每种大米的重量，价格以及数量，求最多能买多少公斤的大米
 */
public class 背包VII {

    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        int len = prices.length;
        int[][] dp = new int[len + 1][n + 1];//dp[i][j] 表示前i个个物品价值为j元 共多重。

        dp[0][0] = 0;
        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 0; k <= amounts[i-1]; k++) {
                    if (j >= k * prices[i-1]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k * prices[i-1]] + k * weight[i-1]);
                    }
                }
            }
        }
        return dp[len][n];
    }
}
