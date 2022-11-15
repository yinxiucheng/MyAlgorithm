package senior.dp.背包型;

/**
 * 800 · 背包问题 IX
 *
 * https://www.lintcode.com/course/24/learn/800?chapterId=134&sectionId=897&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 你总共有n 万元，希望申请国外的大学，要申请的话需要交一定的申请费用，
 * 给出每个大学的申请费用以及你得到这个大学offer的成功概率，大学的数量是 m。如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
 *
 *
 */
public class 背包IX {

    public double backpackIX(int n, int[] prices, double[] probability) {

        for (int i = 0; i < probability.length; i++) {//失败的概率。
            probability[i] = 1 - probability[i];
        }
        int m = prices.length;

        double[][] dp = new double[m+1][n+1];//dp[i][j] 表示前i所学校花费j万元未被录取的概率。

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1.0; // 初始化，对于每个学校，拿不到offer的概率是1，也就是初始化为100%拿不到offer
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <= n ; j++) {
                dp[i][j] = dp[i-1][j];//第i所不申请花费j不被录取的概率
                if (j >= prices[i-1]){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-prices[i-1]] * probability[i-1]);
                }
            }
        }

        return 1 - dp[m][n];
    }
}
