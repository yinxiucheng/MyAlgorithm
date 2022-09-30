package junior.greedy;

/**
 * 150 · 买卖股票的最佳时机 II
 *
 * https://www.lintcode.com/problem/150/description
 * 描述
 * 给定一个数组 prices 表示一支股票每天的价格.
 *
 * 交易次数不限, 不过你不能同时参与多个交易 (也就是说, 如果你已经持有这支股票, 在再次购买之前, 你必须先卖掉它).
 *
 * 设计一个算法求出最大的利润.
 *
 * 输入: [2, 1, 2, 0, 1]
 * 输出: 2
 * 解释:
 *     1. 在第 2 天以 1 的价格买入, 然后在第 3 天以 2 的价格卖出, 利润 1
 *     2. 在第 4 天以 0 的价格买入, 然后在第 5 天以 1 的价格卖出, 利润 1
 *     总利润 2.
 */
public class MaxProfitII {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //dp state 第 i 天 持有、未持有股票时的受益。
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            //dp[i-1][0] 昨天就没有持有该股票， dp[i-1][1] + prices[i] 表示昨天持有，今天卖掉，收入 + prices[i].
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //dp[i-1][1] 昨天持有，依旧不动。dp[i-1][0] - prices[i]表示昨天没持有，今天买入。
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        //最后持有股票 一定小于 手上未持有股票的 受益。
        return dp[n-1][0];
    }
}
