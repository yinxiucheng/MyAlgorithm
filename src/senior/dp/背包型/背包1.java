package senior.dp.背包型;

/**
 * 92 · 背包问题
 *
 * https://www.lintcode.com/problem/92
 *
 * 描述
 * 在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A_{i}A
 * i
 * ​
 *
 * （每个物品只能选择一次且物品大小均为正整数）
 *
 * 数组 = [3,4,8,5]
 * backpack size = 10
 * 9
 * 解释：
 *
 * 装4和5.
 *
 */
public class 背包1 {

    public int backPack(int m, int[] A) {
        int n = A.length;

        //dp[i][j]表示 前i种物品凑出j 是否可能。
        boolean[][] dp = new boolean[n+1][m+1];
        for (int i = 0; i <= n ; i++) {//前 i 个物品凑出 0 是可以的。
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];//不选第i个物品
                if (A[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }

        int res = 0;
        for (int j = m; j >= 0 ; j--) {
            if (dp[n][j]){
                res = j;
                break;
            }
        }

        return res;
    }
}
