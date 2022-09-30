package junior.dp.match;

/**
 * 154 · 正则表达式匹配
 *
 * https://www.lintcode.com/problem/154/
 *
 * 描述
 * 实现支持 '.' 和 '*' 的正则表达式匹配。'.' 匹配任意一个字母。'*' 匹配零个或者多个前面的元素，'*' 前保证是一个非 '*' 元素。
 * 匹配应该覆盖整个输入字符串，而不仅仅是一部分。需要实现的函数是：
 * bool isMatch(string s, string p)
 *
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 *
 *
 * 输入："aab", "c*a*b"
 * 输出：true
 * 解释：
 * "c*" 作为一个整体匹配 0 个 'c' 也就是 ""
 * "a*" 作为一个整体匹配 2 个 'a' 也就是 "aa"
 * "b" 匹配 "b"
 * 所以 "c*a*b" 可以匹配 "aab"
 *
 */
public class IsMatchI {

    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        boolean result = isMatch(s, p);
        System.out.print("the result is " + result);
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 1; i <= n ; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            if (j == 1) {
                dp[0][1] = p.charAt(0) == '.';
            } else {
                // $$$$$$ x*   : x* 匹配 0 个。
                dp[0][j] = dp[0][j-2] && p.charAt(j - 1) == '*';
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                dp[i][j] = false;
                if (p.charAt(j-1) == '*'){// j == 1 进不来，因为 '*'前面必须有 字母。 j> 1, 至少为 2， 保证分支里面的 j-2 不越界
                    dp[i][j] = dp[i][j-2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        //dp[i-1][j] s抹掉一个字符 跟p 去匹配。
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
