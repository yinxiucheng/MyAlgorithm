package DP.双序列;

/**
 * 77 · 最长公共子序列
 * https://www.lintcode.com/course/42/learn/77?chapterId=308&sectionId=2300&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=true
 *
 * 描述
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 *
 */
public class 最长公共子序列 {

    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();

        //dp[i][j] A前i, B的前j 的最长公共子序列
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= m ; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }

}
