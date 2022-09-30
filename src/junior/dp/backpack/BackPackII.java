package junior.dp.backpack;

/**
 * 440 · 背包问题 III
 *
 * 描述
 * 给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
 *
 * 再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?
 *
 */
public class BackPackII {

    /**
     * @param a: an integer array
     * @param v: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] a, int[] v, int m) {

        int n = a.length;

        int[][] dp = new int[n+1][m+1];

        dp[0][0] = 0;

        for (int i = 1; i <= n ; i++) {
            dp[i][0] = 0;
            for (int j = 0; j <= m ; j++) {
                if (j - a[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    //dp[i-1][j] 表示 第 i个物品不选，凑出j体积的 最大值。
                    //随着 j不断增大，a[i-1]在满足 总体积小于 m 的前提下，可以选1、2、3....，
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - a[i-1]] + v[i-1]);
                }
            }
        }

        return dp[n][m];
    }
}
