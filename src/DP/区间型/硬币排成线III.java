package DP.区间型;

/**
 * 396 · 硬币排成线 III
 *
 * https://www.lintcode.com/course/42/learn/396?chapterId=307&sectionId=2298&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 有 n 个硬币排成一条线, 第 i 枚硬币的价值为 values[i].
 *
 * 两个参赛者轮流从任意一边取一枚硬币, 直到没有硬币为止. 拿到硬币总价值更高的获胜.
 *
 * 请判定 第一个玩家 会赢还是会输.
 *
 * 博弈型 + 区间型动态规划。
 * dp[i][j] 表示 先手 跟 后手 之间总价值的差, dp[i][j] == 0, 两个相等也算是TRUE；
 */
public class 硬币排成线III {

    public boolean firstWillWin(int[] A) {
        int n = A.length;
        if (n == 0) return true;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = A[i];
        }

        for (int len = 2; len <= n ; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(A[i] - dp[i+1][j], A[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] >= 0;
    }
}
