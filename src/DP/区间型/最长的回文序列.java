package DP.区间型;

/**
 * 667 · 最长的回文序列
 *
 * https://www.lintcode.com/course/42/learn/667?chapterId=307&sectionId=1861&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 给一字符串 s, 找出在 s 中的最长回文子序列的长度. 你可以假设 s 的最大长度为 1000.
 *
 * 输入： "bbbab"
 * 输出： 4
 * 解释：
 * 一个可能的最长回文序列为 "bbbb"
 */
public class 最长的回文序列 {

    public int longestPalindromeSubseq(String str) {
        char[] charArray = str.toCharArray();
        int n = charArray.length;
        if (n <= 1){
            return n;
        }
        //dp[i][j]表示 i---j 之间的最长回文子序列
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i >= 1){
                dp[i-1][i] = charArray[i-1]== charArray[i] ? 2 : 1;
            }
        }
        // dp[i][j] = max{dp[i+1][j], dp[i][j-1], dp[i+1][j-1] + 2| charArray[i] == charArray[j]}
        for (int len = 3; len <= n; len++) {
            //[i....i + len - 1]
            // i + len - 1 < n  ==>  i < n + 1 - len  ==> i <= n - len
            for (int i = 0; i <= n - len ; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j - 1]);
                if (charArray[i] == charArray[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                }
            }
        }
        return dp[0][n-1];
    }
}
