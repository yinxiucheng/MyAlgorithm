package senior.dp.背包型;

/**
 *440 · 背包问题 III
 * https://www.lintcode.com/course/24/learn/440?chapterId=138&sectionId=2315&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
 *
 * 再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?
 *
 * 输入: A = [2, 3, 5, 7], V = [1, 5, 2, 4], m = 10
 * 输出: 15
 * 解释: 装入三个物品 1 (A[1] = 3, V[1] = 5), 总价值 15.
 */
public class 背包3 {

    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        int[][] dp = new int[n+1][m+1];//dp[i][j] 前i个物品 体积和为j 时的最大价值。
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                dp[i][j] = dp[i-1][j];//不取 第 i 个物品
                if (j >= A[i-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i-1]] + V[i-1]);
                }
            }
        }
        return dp[n][m];
    }
}
