package junior.dp.coordinate;

/**
 * 110 · 最小路径和
 *
 * 描述
 * 给定一个只含非负整数的m∗n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 *
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
       int result = minPathSum(grid);
       System.out.print("the result is " + result);
    }

    public static int minPathSum(int[][] grid){
        if (null == grid || grid.length == 0){
            return 0;
        }
        if (null == grid[0] || grid[0].length == 0){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        //# dp state: (i, j)位置点的最小路径和。
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {//第一列
            dp[i][0] = dp[i-1][0]  + grid[i][0];
        }

        for (int j = 1; j < m; j++) {//第一行
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
