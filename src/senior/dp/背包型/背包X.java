package senior.dp.背包型;

/**
 * 801 · 背包问题X
 *
 * https://www.lintcode.com/course/24/learn/801?chapterId=138&sectionId=944&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 * 描述
 * 你总共有n元，商人总共有三种商品，它们的价格分别是150元,250元,350元，三种商品的数量可以认为是无限多的，
 * 购买完商品以后需要将剩下的钱给商人作为小费，求最少需要给商人多少小费
 *
 */
public class 背包X {

    public int backPackX(int m) {
        int[] prices = {150, 250, 350};
        int[][] dp = new int[4][m+1];// dp[i][j] 前i个物品价值和为j 产生的费用。
        dp[0][0] = 0;

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= m ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= prices[i-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - prices[i-1]] + prices[i-1]);
                }
            }
        }

        int res = m - dp[3][m];
        return res;
    }
}
