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
 *
 * 记忆化搜索来计算
 *
 */
public class 最长的回文序列1 {
    char[] charArray;
    int n;
    int[][] memo;

    public int longestPalindromeSubseq(String str) {
        charArray = str.toCharArray();
        n = charArray.length;
        if (n <= 1){
            return n;
        }
        //
        //dp[i][j]表示 i---j 之间的最长回文子序列
        memo = new int[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                memo[i][j] = -1;
            }
        }
        // dp[i][j] = max{dp[i+1][j], dp[i][j-1], dp[i+1][j-1] + 2| charArray[i] == charArray[j]}
        calculate(0, n-1);
        return memo[0][n-1];
    }

    private void calculate(int start, int end){
        if (memo[start][end] != -1){
            return;
        }
        if (start == end) {
            memo[start][end] = 1;
            return;
        }
        if (start + 1 == end){
            memo[start][end] = charArray[start] == charArray[end] ? 2 : 1;
            return;
        }

        calculate(start + 1, end);
        calculate(start, end - 1);
        calculate(start + 1, end - 1);

        memo[start][end] = Math.max(memo[start + 1][end], memo[start][end -1]);
        if (charArray[start] == charArray[end]){
            memo[start][end] = Math.max(memo[start][end], memo[start+1][end-1] + 2);
        }
    }
}
