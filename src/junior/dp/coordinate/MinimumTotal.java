package junior.dp.coordinate;

/**
 *
 * 109 · 数字三角形
 *
 * https://www.lintcode.com/problem/109/
 *
 * 描述
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class MinimumTotal {

    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {

        int n = triangle.length;
        // dp state : 从顶部到 （i, j） 坐标的最小路径和。
        int[][] dp = new int[n][n];

        //initialization
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) { //初始化第一列, 对角线
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        int best = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, dp[n-1][i]);
        }
       return best;
    }

    //滚动数组版本。
    public int minimumTotal2(int[][] triangle) {

        int n = triangle.length;
        // dp state : 从顶部到 （i, j） 坐标的最小路径和。
        int[][] dp = new int[2][n];

        //initialization
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            dp[i%2][0] = dp[(i-1)%2][0] + triangle[i][0];
            dp[i%2][i] = dp[(i-1)%2][i-1] + triangle[i][i];
            for (int j = 1; j < i; j++) {
                dp[i%2][j] = Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]) + triangle[i][j];
            }
        }
        int best = dp[(n-1)%2][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, dp[(n-1)%2][i]);
        }
        return best;
    }
}
