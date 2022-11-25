package senior.dp.序列型;

/**
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 *
 * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 *
 * 输入 : [4,4,6,1,1,4,2,5]
 * 输出 : 6
 *
 */
public class 买卖股票3 {

    public int maxProfit(int[] P) {
//
        // K  为 1、2、3、4、5，五个阶段 其中 1，3，5  ：
        // 1 表示第一次买入前， 2，持有第一支股票， 3， 第二支买入前， 4、持有第二支  5、卖出第二支
        int len = P.length;

        int[][] dp = new int[len + 1][5 + 1];

        for (int k = 1; k <= 5; k++) {
            dp[0][k] = Integer.MIN_VALUE;
        }

        dp[0][1] = 0;
        for (int i = 1; i <= len; i++) {

            for (int j = 1; j <= 5; j += 2) {// 1, 3, 5,
                dp[i][j] = dp[i - 1][j];//持有
                if (i > 1 && j > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {//今天刚卖出
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + P[i - 1] + P[i - 2]);
                }
            }


            for (int j = 2; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];//刚买入
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {//持有获利
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + P[i - 1] + P[i - 2]);
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= 5; j += 2) {
            res = Math.max(dp[len][j], res);
        }

        return res;
    }
}
