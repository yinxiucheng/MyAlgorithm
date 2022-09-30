package junior.dp.rangedp;

/**
 * 476 · 石子归并
 *
 * https://www.lintcode.com/problem/476/?fromId=161&_from=collection
 *
 * 描述
 * 有一个石子归并的游戏。最开始的时候，有n堆石子排成一列，目标是要将所有的石子合并成一堆。合并规则如下：
 *
 * 每一次可以合并相邻位置的两堆石子
 * 每次合并的代价为所合并的两堆石子的重量之和
 * 求出最小的合并代价。
 */
public class StoneGame {

    /**
     * @param a: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] a) {
        if (null == a || a.length == 0){
            return 0;
        }
        int n = a.length;
        int[] preSum = new int[n+1];

        for (int i = 0; i <= n; i++) {
            preSum[i+1] = preSum[i] + a[i];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n ; len++) {
            for (int i = 0; i < n - len +  1; i++) {
                int j = i + len - 1;
                int sumSegment = preSum[j + 1] - preSum[i];
                // 在求最小的时候，需要初始化成一个很大的数，然后不断更新
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sumSegment);
                }
            }
        }

        return dp[0][n-1];
    }
}
