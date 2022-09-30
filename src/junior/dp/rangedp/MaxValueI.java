package junior.dp.rangedp;

/**
 * 741 · 计算最大值II
 *
 *
 * https://www.lintcode.com/problem/741/
 *
 * 描述
 * 给定一串数字，编写一个函数来计算字符串通过一系列操作能得到的最大值，你可以在任意两个数字之间添加一个加号或乘号。
 * 注意，这题和计算最大值（Calculate Maximum Value）”原题不同，在这题中你可以在任何地方插入括号。
 *
 */
public class MaxValueI {

    public int calcMaxValue(String str) {
        if (null == str || str.length() == 0){
            return 0;
        }
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = str.charAt(i) - '0';
        }

        for (int i = 1; i < n; i++) {
            int val = str.charAt(i) - '0';
            int valPre = str.charAt(i - 1) - '0';
            dp[i-1][i] = Math.max(val + valPre, val * valPre);
        }

        for (int len = 3; len <= n; len++) {
            //当前length 前提下 循环
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                // k在 （i， j）的区间内。
                dp[i][j] = 0;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k+1][j]);
                    dp[i][j] = Math.max(dp[i][j],  dp[i][k] * dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
