package junior.dp.rangedp;

/**
 * 593 · 石头游戏 II
 *
 * https://www.lintcode.com/problem/593
 *
 * 描述
 * 有一个石头游戏。在游戏的开始的时候，玩家挑选了 n 堆石头并围成一个 圈，即第一堆石头与最后一堆石头相邻。
 *
 * 目标是按照下面的规则将石头合并成一堆：
 * 在游戏中的每一步，玩家可以合并两堆相邻的石头为新的一堆石头。分数就是新的石头堆的石头个数。你需要找到最小的总分。
 */
public class StoneGameI {

    /**
     * @param a: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] a) {
        if (null == a || a.length == 0){
            return 0;
        }
        int n = a.length;

        int[][] dp = new int[2 * n][2 * n];
        int[] preSum = new int[2 * n + 1];

        for (int i = 1; i < 2 * n; i++) {
            preSum[i] = preSum[i - 1] + a[(i - 1) % n];
        }

        for (int len = 2; len <= 2 * n ; len++) {
            for (int i = 0; i < 2 * n && i + len - 1 < 2 * n; i++) {
                int j = i + len - 1;
                int sumSegment = preSum[j + 1] - preSum[i];
                // 在求最小的时候，需要初始化成一个很大的数，然后不断更新
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sumSegment);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + n - 1;
            ans = Math.min(dp[i][j], ans);
        }
        return ans;
    }
}
