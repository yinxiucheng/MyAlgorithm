package junior.dp.backpack;

/**
 *
 * 125 · 背包问题（二）
 *
 * 描述
 * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 *
 * 问最多能装入背包的总价值是多大?
 *
 */
public class BackPackI {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @param v: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] a, int[] v) {

        int n = a.length;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;

        for (int i = 1; i <= n ; i++) {//i 个物品选择总体积为 0 ， 价值为0.
            dp[i][0] = 0;
        }

        for (int j = 1; j <= m ; j++) {//一个都不挑， 价值为0.
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (j - a[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j],  dp[i-1][j-a[i-1]] + v[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }
}
