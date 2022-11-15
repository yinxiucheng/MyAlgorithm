package senior.dp.背包型;

/**
 * 563 · 背包问题 V
 *
 * https://www.lintcode.com/course/24/learn/563?chapterId=134&sectionId=2309&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品只能使用一次
 *
 */
public class 背包5 {

    public int backPackV(int[] A, int m) {
        int n = A.length;
        int[][] dp = new int[n+1][m+1];// dp[i][j] 前i个物品 凑满 和为j 的方案总数。

        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 1;//凑 和为0 的方案数为 1；
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                dp[i][j] = dp[i-1][j];// 不选第i个物品的方案总数。
                if (A[i-1] <= j){
                    dp[i][j] += dp[i-1][j - A[i-1]];
                }
            }
        }

        return dp[n][m];
    }
}
