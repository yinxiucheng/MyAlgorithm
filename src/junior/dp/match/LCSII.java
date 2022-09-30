package junior.dp.match;

/**
 * 762 · 最长公共子序列 II
 *
 * https://www.lintcode.com/problem/762/?fromId=161&_from=collection
 *
 * 描述
 * 给定两个序列 P 和 Q 。
 * 你可以对这对 P 这个序列修改不超过 k 个元素到任意的值，并要求两个修改后序列的最长公共子序列最长。
 *
 */
public class LCSII {

    public int longestCommonSubsequence2(int[] p, int[] q, int k) {
        int n = p.length;
        int m = q.length;

        //dp, state 修改 g次后，p 前 i， q的前 j 个字符串的最长公共子串。
        int[][][] dp = new int[n+1][m+1][k+1];
        dp[0][0][0] = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (p[i-1] == q[j-1]){
                    dp[i][j][0] = dp[i-1][j-1][0] + 1;
                }else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]);
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                for (int g = 1; g <= k ; g++) {
                    if (p[i-1] == q[j-1]){
                        dp[i][j][g] = Math.max(dp[i-1][j-1][g] + 1, Math.max(dp[i-1][j][g], dp[i][j-1][g]));
                    }else {
                        dp[i][j][g] = Math.max(dp[i-1][j-1][g-1] + 1, Math.max(dp[i-1][j][g], dp[i][j-1][g]));
                    }
                }
            }
        }
        return dp[n][m][k];
    }
}
