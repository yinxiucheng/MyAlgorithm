package DP.双序列;

/**
 * 首先， 如果X的长度不等于A的长度 + B的长度，
 * f[s][i][j]  s = i + j. 降维  f[i][j].
 *
 * 描述
 * 给出三个字符串s1、s2、s3，判断s3是否由s1和s2交叉构成。
 */
public class 交叉字符串 {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();
        char[] X = s3.toCharArray();
        int n = A.length;
        int m = B.length;
        if (n + m != X.length){
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0){
                    dp[0][0] = true;//空串是由 空串1， 空串2组成的。
                    continue;
                }

                if (i > 0 && X[i + j - 1] == A[i - 1] && dp[i-1][j]){
                    dp[i][j] = true;
                }

                if (j > 0 && X[i + j - 1] == B[j - 1] && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][m];
    }

}
