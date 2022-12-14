package senior.dp.坐标型;

/**
 * 114 · 不同的路径
 *
 * https://www.lintcode.com/problem/114/
 */
public class 不同的路径 {

    public int uniquePaths(int m, int n) {
        // write your code here

        //初始 f[0][0] = 1;
        //边界 f[i][0] = 1, f[0][j] = 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }
}
