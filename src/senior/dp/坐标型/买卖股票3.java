package senior.dp.坐标型;

/**
 * 买卖两次
 */
public class 买卖股票3 {
    public static void main(String[] args) {
        int[] P = {2, 1};
        maxProfit(P);
    }
    public static int maxProfit(int[] P) {
       int n = P.length;
       if (n == 0){
           return 0;
       }

       int[][] f = new int[n+1][5 + 1];
        int i, j, k;
        for (k = 1; k <= 5; k++) {//前0天，状态k 下的获利。
            f[0][k] = Integer.MIN_VALUE;
        }
        f[0][1] = 0;
        for (i = 1; i <= n; i++) {
            // 第 j次买入前。 每天计算的盈利，昨天 - 前天。
            //f[i][j] = max{f[i-1][j], f[i - 1][j - 1] + P[i - 1] - P[i - 2]}
            //手里没有股票
            for (j = 1; j <= 5; j += 2) {
                f[i][j] = f[i-1][j]; //keep state.

                //刚卖出。 f[i-1][j-1] + P[i-1] - P[i-2] 手里有股票，今天刚卖出
                if (j > 1 && i > 1 && f[i-1][j-1]!= Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + P[i-1] - P[i-2]);
                }
            }

            for (j = 2; j <= 5 ; j += 2) {
                f[i][j] = f[i-1][j - 1];// 刚买入，

                if (i > 1 && f[i-1][j] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j] + P[i-1] - P[i-2]);
                }
            }
        }

        int res = 0;
        for (k = 1; k <= 5; k += 2) {
            res = Math.max(f[n][k], res);
        }

        return  res;
    }
}
