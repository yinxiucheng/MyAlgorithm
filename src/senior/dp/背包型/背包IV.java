package senior.dp.背包型;

/**
 * 562 · 背包问题 IV
 *
 * https://www.lintcode.com/course/24/learn/562?chapterId=138&sectionId=942&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品可以使用无数次
 */
public class 背包IV {

    public int backPackIV(int[] A, int m) {
        int n = A.length;
        int[][] dp = new int[n+1][m+1]; //dp[i][j] 表示前i个物品体积和为j 的方案数。

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;// 前i个物品，都不选体积为j时的方案数为1；
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                dp[i][j] = dp[i-1][j];//不选的方案数
                if (j >= A[i-1]){
                    dp[i][j] += dp[i][j - A[i-1]];
                }
            }
        }
        return dp[n][m];
    }
}
