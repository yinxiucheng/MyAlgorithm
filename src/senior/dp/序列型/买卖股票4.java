package senior.dp.序列型;

public class 买卖股票4 {

    public int maxProfit(int k, int[] P) {
        // write your code here
        int N = P.length;
        if (N == 0){
            return 0;
        }
        if (k > N/2){
            int res = 0;
            for (int i = 1; i < N ; i++) {
                if (P[i] - P[i-1] > 0){
                    res += P[i] - P[i-1];
                }
            }
            return res;
        }

        int[][] dp = new int[N+1][2*k + 1 + 1];
        for (int j = 1; j <= 2*k + 1 ; j++) {
            dp[0][k] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;

        for (int i = 1; i <= N ; i++) {

            for (int j = 1; j <= 2*k + 1 ; j += 2) {
                dp[i][j] = dp[i-1][j];//keep state
                if (i > 1&& j > 1 && dp[i-1][j-1] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + P[i-1] - P[i-2]);
                }
            }

            for (int j = 2; j <= 2 *k + 1 ; j += 2) {
                dp[i][j] = dp[i-1][j-1];//刚买入
                if (i > 1 && dp[i-1][j] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + P[i-1] - P[i-2]);
                }
            }
        }

        int res = 0;
        for (int j = 1; j <= 2*k + 1 ; j+= 2) {
            res = Math.max(res, dp[N][j]);
        }
        return res;
    }
}
