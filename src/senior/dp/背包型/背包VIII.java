package senior.dp.背包型;

/**
 *
 * 背包问题VIII
 *
 * 给一些不同价值和数量的硬币。找出[1，n]范围内的总值有多少种形成方式？
 *
 * https://www.lintcode.com/course/24/learn/799?chapterId=141&sectionId=957&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 样例 1:
 * 	输入:
 * 		n = 5
 * 		value = [1,4]
 * 		amount = [2,1]
 * 	输出:  4
 *
 * 	解释:
 * 	可以组合出1，2，4，5
 *
 * 样例 2:
 * 	输入:
 * 		n = 10
 * 		value = [1,2,4]
 * 		amount = [2,1,1]
 * 	输出:  8
 *
 * 	解释:
 * 	可以组合出1-8所有数字。
 *
 */
public class 背包VIII {

    public int backPackVIII(int n, int[] value, int[] amount) {
        int len = value.length;
        boolean[][] dp = new boolean[len+1][n+1];// dp[i][j] 表示前i种硬币构成总和为j 是否可以。
        dp[0][0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= amount[i - 1]; k++) {
                    if (j >= k * value[i - 1]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - k * value[i - 1]];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[len][i]) ans ++;
        }

        return ans;
    }

}
