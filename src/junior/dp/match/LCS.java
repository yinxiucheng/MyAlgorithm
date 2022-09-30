package junior.dp.match;

/**
 * 77 · 最长公共子序列
 *
 * https://www.lintcode.com/problem/77/
 *
 * 描述
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 */
public class LCS {

    public int longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        //#state a 的 前 i个字符串跟 b的前 j 个字符 的最长匹配度值。
        int[][] dp = new int[2][m + 1];
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            dp[i % 2][0] = 0;
            for (int j = 1; j <= m; j++) {
                dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 1] + 1);
                }
            }
        }
        return dp[n % 2][m];
    }
}
