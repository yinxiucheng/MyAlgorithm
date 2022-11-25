package senior.dp.序列型;

/**
 * 房屋染色 II
 *
 * https://www.lintcode.com/course/42/learn/516/description?chapterId=305&sectionId=1799&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=true
 *
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你希望每两个相邻的房屋颜色不同
 *
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。找到油漆所有房子的最低成本。
 *
 */
public class 房屋染色2 {

    public int minCostII(int[][] A) {

        //dp[i][j] 第i所房子染成 颜色j 时的最小花费。
        // dp[i][j] = min{dp[i-1][k] + costs[i][j]}, k != j.
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int K = A[0].length;
        if (K == 0){
            return 0;
        }

        int[][] dp = new int[n+1][K];
        for (int k = 0; k < K; k++) {
            dp[0][k] = 0;
        }

        for (int i = 1; i <= n ; i++) {

            int a = -1,  b = -1;
            for (int k = 0; k < K; k++) {
                if (a == -1 || dp[i - 1][k] < dp[i - 1][a]) {
                    b = a;
                    a = k;
                } else {
                    if (b == -1 || dp[i - 1][k] < dp[i - 1][b]) {
                        b = k;
                    }
                }
            }
            b = b == -1 ? a : b;
            for (int j = 0; j < K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (j != a){
                   dp[i][j] = dp[i-1][a] + A[i][j];
                }else {
                    dp[i][j] = dp[i-1][b] + A[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < K; k++) {
           res = Math.min(res, dp[n][k]);
        }

        return res;
    }
}
