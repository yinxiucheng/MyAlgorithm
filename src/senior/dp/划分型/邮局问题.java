package senior.dp.划分型;

/**
 * 435 · 邮局问题
 *
 */
public class 邮局问题 {

    public int postOffice(int[] A, int K) {

        int N = A.length;

        int[][] dp = new int[N+1][K+1];//dp[i][k] 前i房子，建立k 个邮局，min distance;

        for (int k = 0; k <= K; k++) {
            dp[0][k] = 0;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            for (int k = 1; k <= K; k++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j >= 0 ; j--) {
                    if (dp[j][k-1] != Integer.MAX_VALUE){
                        min = Math.min(min, dp[j][k-1] + getDistance(j, i));
                    }
                    dp[i][k] = Math.min(dp[i][k], min);
                }
            }
        }
        return dp[N][K];
    }

    private int getDistance(int j, int i) {
        if (i == j) {
            return 0;
        }
        if ((i - j) % 2 == 1) {
            return (i - j) / 2 * 2 + 1;
        } else {
            return (i - j) / 2 * 2;
        }
    }
}
