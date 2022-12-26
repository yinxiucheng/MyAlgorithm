package DP.背包;

/**
 * 668 · 一和零
 *
 * https://www.lintcode.com/course/42/learn/668?chapterId=308&sectionId=1832&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 在计算机世界中, 由于资源限制, 我们一直想要追求的是产生最大的利益.
 * 现在，假设你分别是 m个 0 和 n个 1 的统治者. 另一方面, 有一个只包含 0 和 1 的字符串构成的数组.
 * 现在你的任务是找到可以由 m个 0 和 n个 1 构成的字符串的最大个数. 每一个 0 和 1 均只能使用一次
 */
public class 一和零 {

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0){
            return 0;
        }
        int T = strs.length;

        int[] ctn0 = new int[T];
        int[] ctn1 = new int[T];

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '0') {
                    ++ctn0[i];
                } else {
                    ++ctn1[i];
                }
            }
        }

        int[][][] dp = new int[T + 1][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][i][j] = 0;
            }
        }

        for (int i = 1; i <= T ; i++) {
            for (int j = 0; j <= m ; j++) {
                for (int k = 0; k <= n ; k++) {
                    dp[i][j][k] = dp[i-1][j][k];// 第 i 个字符串不用。

                    if (j >= ctn0[i-1] && k >= ctn1[i-1]){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j - ctn0[i-1]][k - ctn1[i-1]] + 1);
                    }
                }
            }
        }

        //答案求的是在 不超过 m, n 的前提下， 使用的字符串最多。
        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n ; j++) {
                res = Math.max(res, dp[T][i][j]);
            }
        }
        return res;
    }
}
