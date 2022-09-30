package junior.dp.backpack;

/**
 * 92 · 背包问题
 *
 * https://www.lintcode.com/problem/92/
 *
 * 描述
 * 在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为Ai
 *
 * （每个物品只能选择一次且物品大小均为正整数）
 */
public class BackPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] a) {

        int n = a.length;

        //dp state 前 i个数是否能凑出 和为 j 的
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (j >= a[i - 1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - a[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int j = m; j >= 0 ; j--) {
            if (dp[n][j]){
                return j;
            }
        }
        return 0;
    }
}
