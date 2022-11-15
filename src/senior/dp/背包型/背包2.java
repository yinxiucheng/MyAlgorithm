package senior.dp.背包型;

/**
 * 125 · 背包问题（二）
 *
 * https://www.lintcode.com/problem/125
 *
 * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 *
 * 问最多能装入背包的总价值是多大?
 *
 */
public class 背包2 {

    public int backPackII(int m, int[] A, int[] V) {
        //dp[i][j] 前i个物品,选出一些和为j的 的总价值。
        int n = A.length;
        int len = V.length;
        int[][] dp = new int[n+1][len + 1];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if (A[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + V[i-1]);
                }
            }
        }
        return dp[n][m];
    }
}
