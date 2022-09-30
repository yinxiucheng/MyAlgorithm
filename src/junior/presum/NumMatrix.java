package junior.presum;

/**
 * 665 · 平面范围求和 -不可变矩阵
 * 区间和
 *
 * https://www.lintcode.com/problem/665/description?fromId=161&_from=collection
 *
 * 描述
 * 给一 二维矩阵,计算由左上角 (row1, col1) 和右下角 (row2, col2) 划定的矩形内元素和.
 */
public class NumMatrix {
    int[][] dp = null;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n+1][m+1];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                dp[i + 1][j + 1] = dp[i][j+1] + dp[i+1][j] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
