package senior.dp.背包型;

/**
 * 740 · 零钱兑换 2
 *
 * https://www.lintcode.com/problem/740/solution/34623
 *
 * 描述
 * 给出不同面值的硬币以及总金额. 试写一函数来计算构成该总额的组合数量. 你可以假设每一种硬币你都有无限个.
 * 
 * 输入: amount = 8 和 coins = [2, 3, 8]
 * 输出: 3
 * 解释:
 * 有3种方法:
 * 8 = 8
 * 8 = 3 + 3 + 2
 * 8 = 2 + 2 + 2 + 2
 */
public class 零钱兑换2 {

    //多重背包
    public int change(int amount, int[] coins) {
        if (null == coins || coins.length == 0){
            return 0;
        }
        int n = coins.length;
        //dp[i][j] 表示用前i种硬币凑 amount 为 j 的 number 数。
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] = 1;// 用 0 种表示 数额为0的 方案数 为1.

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount ; j++) {
                dp[i][j] = dp[i-1][j];//第i中硬币不取的 方案数。
                if (j >= coins[i-1]){// coins index 的坐标对应 第 i 种硬币。
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
}
