package DP.双序列;

/**
 * 154 · 正则表达式匹配
 * https://www.lintcode.com/course/42/learn/154?chapterId=308&sectionId=1834&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 实现支持 '.' 和 '*' 的正则表达式匹配。'.' 匹配任意一个字母。
 * '*' 匹配零个或者多个前面的元素，'*' 前保证是一个非 '*' 元素。
 * 匹配应该覆盖整个输入字符串，而不仅仅是一部分。需要实现的函数是：
 * bool isMatch(string s, string p)
 *
 */
public class 正则表达式匹配 {

    //字符串A， B是匹配串
    //case1: A[n-1] == B[m-1] 最后一个相等，且前面的匹配。
    //case2: B[n-1] 为 '.',  A[0...n-2] 跟 B[0...m-2]匹配
    //case3: B[n-1] 为 '*'， B[n-2] 为c, 情况一 c* 扔掉， f[i][j-2]； 情况二： B[n-2] 为'.'或者 B[j-2] == A[i-1] 即 A的最后一个也为 c.

    public boolean isMatch(String ss, String pp) {
        char[] S = ss.toCharArray();
        char[] P = pp.toCharArray();
        int n = S.length;
        int m = P.length;

        //dp[i][j] S的前i个字符 跟 P的前 j个字符是否匹配。
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;// 空串匹配空串， return true;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = false;
                    continue;
                }

                dp[i][j] = false;
                if(P[j-1] == '*'){
                    // c* 匹配 0个
                    if (j > 1){
                        dp[i][j] = dp[i][j-2];
                    }
                    // c* 匹配 1个， 消耗掉一个后，保留继续去匹配。
                    if (i > 0 && j > 1 && (P[j-2] == S[i -1] || P[j-2] == '.')){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else {
                    if ( i > 0 && (P[j-1] == '.' || P[j-1] == S[i-1])){
                       dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
