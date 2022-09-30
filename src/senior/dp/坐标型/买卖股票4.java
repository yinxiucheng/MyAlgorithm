package senior.dp.坐标型;

public class 买卖股票4 {

    public int maxProfit(int K, int[] P) {
        int n = P.length;
        if (K >= n/2){
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (P[i] > P[i-1]){
                    res += P[i] - P[i-1];
                }
            }
            return res;
        }

        int[][] f = new int[n + 1][2*K + 2];

        int i, j, k;
        for (k = 1; k <= 2*K + 1; k++) {
            f[0][k] = Integer.MIN_VALUE; //前0天， 状态k下的获益。
        }
        f[0][1] = 0;

        for (i = 1; i <= n; i++) {

            //空仓
            for (j = 1; j <= 2*K + 1 ; j += 2) {
                f[i][j] = f[i - 1][j];//keep state

                if (i > 1 && j > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + P[i-1] - P[i-2]);
                }
            }

            //持有股票
            for (j = 2; j <= 2*K + 1; j+= 2) {
                f[i][j] = f[i-1][j-1];//当天买入， 昨天空仓到今天买入，买入花的钱下一次计算。

                if (i > 1 && f[i-1][j] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j] + P[i-1] - P[i-2]);
                }
            }
        }
        int ans = 0;
        for (k = 1; k <= 2*K + 1; k+=2) {// 从所有空仓 选出最大的。
            ans = Math.max(ans, f[n][k]);
        }
        return ans;
    }
}
