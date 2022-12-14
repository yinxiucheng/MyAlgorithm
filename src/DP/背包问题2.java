package DP;

/**
 *
 * https://www.lintcode.com/course/42/learn/125?chapterId=307&sectionId=1862&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 * 125 · 背包问题（二）
 *
 * 描述
 * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 *
 * 问最多能装入背包的总价值是多大?
 *
 */
public class 背包问题2 {

    public int backPackII(int M, int[] A, int[] V) {
        int n = A.length;

        //dp[i][j] 表示前i个物品，体总为j的 最大总价值。
        int[][] dp = new int[n+1][M+1];

        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 0;//前i个物品重量为0， 总价值为0；
        }

        for (int m = 0; m <= M ; m++) {
            dp[0][m] = Integer.MIN_VALUE;//0个物品构成重量为m时，总价值为Integer.MIN_VALUE，没法构成。
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M ; j++) {
                dp[i][j] = dp[i-1][j];//第i个不选。
                if (j >= A[i-1] && dp[i-1][j - A[i-1]] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - A[i-1]] + V[i-1]);
                }
            }
        }
        int res = 0;
        for (int m = 0; m <= M ; m++) {
            if (dp[n][m] != Integer.MIN_VALUE){// 前n个物品中， 总量(0 ~ M) 中 价值最大。
                res = Math.max(res, dp[n][m]);
            }
        }
        return res;
    }
}
