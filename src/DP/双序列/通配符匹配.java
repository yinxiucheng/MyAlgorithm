package DP.双序列;

/**
 * 192 · 通配符匹配
 *
 * https://www.lintcode.com/course/42/learn/192?chapterId=308&sectionId=2302&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 给定一个字符串 s 和一个字符模式 p ，实现一个支持 '?' 和 '*' 的通配符匹配。匹配规则如下：
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个串完全匹配才算匹配成功。
 *
 */
public class 通配符匹配 {

    // A, B : B 可能包含 ？， *。
    // B 中的 * 不用连带前一个字符去匹配。 * 代表 0 ~ N个字符
    public boolean isMatch(String s, String p) {
        char[] A = s.toCharArray();
        char[] B = p.toCharArray();
        int n = A.length;
        int m = B.length;

        //dp[i][j] 表示A的前i个字符，跟B的前j个字符匹配。
        boolean[][] dp = new  boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }

                if (j == 0){
                    dp[i][j] = false;
                    continue;
                }

                // j > 0
                dp[i][j] = false;
                if (B[j - 1] != '*') {
                    if (i > 0 && (B[j - 1] == '?' || B[j - 1] == A[i - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];//A、B各自消耗一位。
                    }
                } else {
                    dp[i][j] = dp[i][j-1];//匹配 0 个。
                    if (i > 0){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
