package senior.dp.背包型;

/**
 * 89 · K数之和
 *
 * https://www.lintcode.com/problem/89/?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 * 描述
 * 给定 n 个不同的正整数，整数 k(k \leq n)(k≤n)以及一个目标数字 target。　
 * 在这 n 个数里面找出 k 个数，使得这 k 个数的和等于目标数字，求问有多少种方案？
 *
 *
 */
public class K数之和 {

    public int kSum(int[] A, int K, int target) {
        int len = A.length;
        int[][][] dp = new int[len + 1][K + 1][target+1];

        for (int i = 0; i <= len ; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= K && j <= i ; j++) {
                for (int t = 1; t <= target ; t++) {
                    dp[i][j][t] = dp[i-1][j][t];
                    if (t >= A[i-1]) {
                        dp[i][j][t] += dp[i-1][j-1][t - A[i-1]];
                    }
                }
            }
        }

       return dp[len][K][target];
    }
}
