package senior.dp.坐标型;

/**
 *
 */
public class 房屋染色II {

    public static void main(String[] args) {
        int[][] C = {{5}};
        minCostII(C);
    }
    public static int minCostII(int[][] C) {
        int n = C.length;
        if (n == 0) { return  0;}

        int K = C[0].length;
        if (K == 0) { return 0;}

        int[][] dp = new int[n + 1][K];// dp[i][k]

        int i, j, k, a, b;
        for (k = 0; k < K; k++) {
            dp[0][k] = 0;//第 0 所房子花费 0 。
        }

        for (i = 1; i <= n; i++) {
            a = b = -1;
            //find minimum and 2nd minimum
            //dp[i-1][0]....dp[i-1][K-1]
            for (k = 0; k < K; k++) {
                if (a == -1 || dp[i - 1][k] < dp[i - 1][a]) {
                    b = a;
                    a = k;
                } else {
                    if (b == -1 || dp[i - 1][k] < dp[i - 1][b]) {
                        b = k;
                    }
                }
            }
            if (K == 1){
                b = a;
            }
            for (j = 0; j < K; j++) {
                if (j != a) {
                    dp[i][j] = dp[i - 1][a] + C[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][b] + C[i - 1][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (k = 0; k < K; k++) {
            res = Math.min(dp[n][k], res);
        }
        return res;
    }
}
