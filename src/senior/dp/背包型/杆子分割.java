package senior.dp.背包型;

/**
 * 700 · 杆子分割
 *
 * https://www.lintcode.com/course/24/learn/700?chapterId=138&sectionId=945&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 给一个 n 英寸长的杆子和一个包含所有小于 n 的尺寸的价格. 确定通过切割杆并销售碎片可获得的最大值.
 */
public class 杆子分割 {

    public int cutting(int[] prices, int value) {
        int n = prices.length;
        int[] lengthArray = new int[n];

        for (int i = 0; i < n; i++) {
            lengthArray[i] = i + 1;
        }

        int len = lengthArray.length;
        int[][] dp = new int[len+1][value + 1];//dp[i][j] 前i个杆子总和为j的最大价值。

        for (int i = 0; i <= len ; i++) {
           dp[i][0] = 0;
        }

        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <= value ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= i){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - lengthArray[i-1]] + prices[i-1]);
                }
            }
        }
        return dp[n][value];
    }
}
