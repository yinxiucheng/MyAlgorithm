package junior.greedy;

/**
 * 151 · 买卖股票的最佳时机 III
 *
 * 描述
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 *
 *
 */
public class MaxProfitIII {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int K = 2;

        //dp,state 第 j天 第i笔时 受益最大值。
        int[][] dp = new int[K+1][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;//0笔交易，没有受益。
        }

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;// 第0天没法卖出，只能买入,不能完成交易。
        }

        for (int i = 1; i <= K ; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j] = dp[i][j-1];////dp[i][j] = dp[i][j-1]表示不动
                for (int m = 0; m < j; m++) { //第m天买入。
                    dp[i][j] = Math.max(dp[i][j], prices[j] - prices[m] + dp[i-1][m]);
                }
            }
        }

        return dp[K][n-1];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int K = 2;

        //dp,state 第 j天 第i笔时 受益最大值。
        int[][] dp = new int[K+1][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;//0笔交易，没有受益。
        }

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;// 第0天没法卖出，只能买入,不能完成交易。
        }

        for (int i = 1; i <= K ; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n ; j++) {
                //（0，j-1）天里某一天买入, 受益的最大diff值存储在 maxDiff 里。
                maxDiff = Math.max(maxDiff, dp[i-1][j-1] - prices[j-1]);
                //prices[j] + maxDiff ： 第 j 天卖出，（0，j-1）天里某一天买入。
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
            }
        }

        return dp[K][n-1];
    }
}
