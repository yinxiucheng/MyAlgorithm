package DP;

/**
 * https://www.lintcode.com/course/42/learn/669?chapterId=303&sectionId=1767&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量. 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 *
 *
 */
public class 换硬币 {

    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0){
            return -1;
        }
        int len = coins.length;
        //dp[i]表示 面额为i时 最好的硬币数量。
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < len ; j++) {
                //dp[i - coins[j]] == Integer.MAX_VALUE 表示 dp[i - coins[j]] 取不到。
                //比如总共 构成面额27， 现在 coins[j] == 5, 则 i - coins[i] = 22, dp[22] 为 Integer.MAX_VALUE表示没法从现有的 coins里组成面额22.
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[len - 1] == Integer.MAX_VALUE){
            dp[len - 1] = -1;
        }
        return dp[len - 1];

    }
}
