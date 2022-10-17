package senior.presum;

/**
 * 1840 · 矩阵还原
 *
 * https://www.lintcode.com/problem/1840/description
 *
 * 现有一个nn行mm列的矩阵beforebefore，对于before里的每一个元素before[i][j]before[i][j]
 * ，我们会使用以下算法将其转化为after[i][j]after[i][j]。现给定afterafter矩阵，请还原出原有的矩阵beforebefore。
 */
public class 矩阵还原 {

    public int[][] matrixRestoration(int n, int m, int[][] after) {
        int[][] ans = new int[n][m];
        ans[0][0] = after[0][0];

        for (int i = 1; i < n; i++) {
            ans[i][0] = after[i][0] - after[i-1][0];
        }

        for (int j = 1; j < m; j++) {
            ans[0][j] = after[0][j] - after[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ans[i][j] = after[i][j] - after[i][j-1] - after[i-1][j] + after[i-1][j-1];
             }
        }
        return ans;
    }
}
