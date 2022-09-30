package senior.dp.坐标型;

public class 不同的路径II {

    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        // dp[i][j] 表示有多少种方式 走到 格子(i, j)
        if (A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = 0;
                if (i > 0){
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0){
                    dp[i][j] += dp[i][j - 1];
                }

            }
        }
        return dp[n-1][m-1];
    }
}
