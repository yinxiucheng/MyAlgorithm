package junior.dp.coordinate;

/**
 * 515 · 房屋染色
 *
 * https://www.lintcode.com/problem/515/?fromId=161&_from=collection
 *
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
 *
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用，依此类推。找到油漆所有房子的最低成本。
 *
 *
 * 输入: [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 解释: 第一个屋子染蓝色，第二个染绿色，第三个染蓝色，最小花费：2 + 5 + 3 = 10.
 *
 *
 * 输入: [[1,2,3],[1,4,6]]
 * 输出: 3
 */
public class MinCost {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 2, 3},
                {1, 4, 6}
        };

    }

    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }

        //dp state : 第i个屋子 选第 0、1、2种颜色，花费最小。
        int[][] dp = new int[2][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i%2][j] = Integer.MAX_VALUE;//第i座房子选 第j 种颜色。
                for (int k = 0; k < 3; k++) {
                    if (k != j){
                        dp[i%2][j] = Math.min(dp[i%2][j], dp[(i-1)%2][k] + costs[i][j]);
                    }
                }
            }
        }
        return Math.min(Math.min(dp[(n-1)%2][0], dp[(n-1)%2][1]), dp[(n-1)%2][2]);
    }
}
