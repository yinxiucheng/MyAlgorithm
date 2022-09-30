package junior.dp.match;

/**
 * 192 · 通配符匹配
 *
 * https://www.lintcode.com/problem/192/
 *
 * 描述
 * 给定一个字符串 s 和一个字符模式 p ，实现一个支持 '?' 和 '*' 的通配符匹配。匹配规则如下：
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *  两个串完全匹配才算匹配成功。
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] && p.charAt(j-1) == '*';
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
                }

            }
        }
        return dp[n][m];
    }
}
