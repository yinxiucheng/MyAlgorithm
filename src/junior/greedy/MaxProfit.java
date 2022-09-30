package junior.greedy;

/**
 * 149 · 买卖股票的最佳时机
 *
 * 描述
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 *
 * 输入: [3, 2, 3, 1, 2]
 * 输出: 1
 * 说明：你可以在第三天买入，第四天卖出，利润是 2 - 1 = 1
 *
 */
public class MaxProfit {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0){
            return 0;
        }

        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}
