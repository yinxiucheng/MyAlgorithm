package senior.dp.背包型;


/**
 * 卡牌游戏
 * https://www.lintcode.com/problem/1448/?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 * 描述
 * 现在有一个卡牌游戏，先给出卡牌的数量n，再给你两个非负整数totalProfit、totalCost，然后给出每张卡牌的利润值 a[i]和成本值b[i]，
 * 现在可以从这些卡牌中任意选择若干张牌，组成一个方案，问有多少个方案满足所有选择的卡牌利润和大于totalProfit且成本和小于totalCost。
 *
 * 输入：n = 2，totalProfit = 3，totalCost = 5，a = [2,3]，b = [2,2]
 * 输出：1
 * 解释：
 * 此时只有一个合法的方案，就是将两个卡牌都选上，此时a[1]+a[2] = 5 > totalProfit 且 b[1] + b[2] < totalCost，满足题意。
 *
 * 输入：n = 3，totalProfit = 5，totalCost = 10，a = [6,7,8]，b = [2,3,5]
 * 输出： 6
 * 解释：
 * 假设一个合法方案(i,j)表示选择了第i张卡牌和第j张卡牌。
 * 则此时合法的方案有：
 * (1),(2),(3),(1,2),(1,3),(2,3)
 *
 */
public class 卡牌游戏 {

    private int MOD = 1000000007;

    public int numOfPlan(int n, int totalProfit, int totalCost, int[] A, int[] B) {
        totalProfit++;
        //dp[i][profit][cost] 表示前 i张卡牌，产生 >= profit, 成本 < cost 的方案数。
        int[][][] dp = new int[n+1][totalProfit + 1][totalCost + 1];

        for (int cost = 1; cost <= totalCost ; cost++) {
            dp[0][0][cost] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int profit = 0; profit <= totalProfit ; profit++) {
                for (int cost = 0; cost <= totalCost; cost++) {
                    dp[i][profit][cost] = dp[i-1][profit][cost];
                    if (cost >= B[i-1]){
                        //记住这里的三种循环处理的这个中间层。
                        int prevProfit = Math.max(0, profit - A[i-1]);
                        dp[i][profit][cost] += dp[i-1][prevProfit][cost - B[i-1]];
                        dp[i][profit][cost] %= MOD;
                    }
                }
            }
        }

        return dp[n][totalProfit][totalCost];
    }
}
