package senior.dp.坐标型;

public class 最小路径和 {

    public int minPathSum(int[][] A) {
        // write your code here
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];//dp[i][j] 表示 i，j 位置的最小路径和。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0){
                    dp[0][0] = A[0][0];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + A[i][j]);
                }
                if (j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + A[i][j]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
