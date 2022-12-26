package DP.难题;

/**
 *  89. K数之和。
 *
 *  序列 + 状态
 *
 *  f[i][k][s] = f[i-1][k][s] + f[i-1][k-1][s-Ai-1]
 */
public class K数之和up {

    public int kSum(int[] A, int K, int S) {
        int n = A.length;

        int[][][] dp = new int[2][K+1][S+1];
        int old, now = 0;

        for (int j = 0; j <= K; j++) {
            for (int s = 0; s <= S; s++) {
                dp[now][j][s] = 0;
            }
        }
        
        dp[now][0][0] = 1;
        for (int i = 1; i <= n ; i++) {
            old = now;
            now = 1 - now;

            for (int k = 0; k <= K ; k++) {
                for (int s = 0; s <= S; s++) {
                    dp[now][k][s] = dp[old][k][s];//最后一个不选。
                    if (k > 0 && s - A[i -1] >= 0){
                        dp[now][k][s] += dp[old][k-1][s - A[i-1]];
                    }
                }
            }
        }
        return dp[now][K][S];
    }

}
