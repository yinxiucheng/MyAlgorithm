package DP.背包;

/**
 *
 */
public class 背包问题3 {

    public int backPackIII(int M, int[] A, int[] V) {
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
            for (int w = 0; w <= M ; w++) {
                dp[i][w] = dp[i-1][w];//第i个不选。
                if (w >= A[i-1] && dp[i][w - A[i-1]] != Integer.MIN_VALUE){
                    dp[i][w] = Math.max(dp[i][w], dp[i][w - A[i-1]] + V[i-1]);
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
