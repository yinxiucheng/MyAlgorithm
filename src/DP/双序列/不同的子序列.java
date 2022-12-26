package DP.双序列;


/**
 *  118 · 不同的子序列
 *
 *  https://www.lintcode.com/course/42/learn/118?chapterId=308&sectionId=1831&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 *  描述
 * 给定字符串 S 和 T, 字符串S中有多少个子序列字符串和字符串T相同。
 *
 * 子序列字符串是原始字符串删除一些(或零个)字符之后得到的字符串, 并且不能改变剩下字符的相对位置。(比如 "ACE" 是 ABCDE 的一个子序列, 而 "AEC" 不是)
 *
 */
public class 不同的子序列 {

    public int numDistinct(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int n = S.length;
        int m = T.length;

        if (n < m){
            return 0;
        }
        //
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 1;// 空串跟任何的串都匹配。
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                dp[i][j] = dp[i-1][j];//不匹配 S 的最后一个元素。
                if (S[i-1] == T[j-1]){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
