package senior.towpoint;

/**
 * 151 · 买卖股票的最佳时机 III
 * https://www.lintcode.com/problem/151/
 *
 * 描述
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 *
 * 输入 : [4,4,6,1,1,4,2,5]
 * 输出 : 6
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            int maxLeft = getMaxCost(prices, 0, i);
            int maxRight = getMaxCost(prices, i, n);
            ans = Math.max(ans, maxLeft + maxRight);
        }
        return ans;
    }

    //[left, right), 左闭右开
    private int getMaxCost(int[] prices, int left, int right){
        int minPrice = Integer.MAX_VALUE;
        int cost = 0;
        for (int i = left; i < right; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            cost = Math.max(prices[i] - minPrice, cost);
        }
        return cost;
    }
}
