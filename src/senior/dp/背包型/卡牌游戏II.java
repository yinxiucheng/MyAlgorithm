package senior.dp.背包型;

/**
 * 1538 · 卡牌游戏 II
 * https://www.lintcode.com/course/24/learn/1538?chapterId=134&sectionId=898&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 你跟你的朋友在玩一个卡牌游戏，总共有 n 张牌。每张牌的成本为 cost[i] 并且可以对对手造成 damage[i] 的伤害。
 * 你总共有 totalMoney 元并且需要造成至少 totalDamage 的伤害才能获胜。每张牌只能使用一次，判断你是否可以取得胜利。
 *
 * 输入:
 * cost = [1,2,3,4,5]
 * damage = [1,2,3,4,5]
 * totalMoney = 10
 * totalDamage = 10
 *
 * 输出: true
 * 样例说明: 我们可以使用 [1,4,5] 去造成10点伤害，总花费为10。
 */
public class 卡牌游戏II {

    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        int n = cost.length;
        int[][] dp = new int[n+1][totalMoney+1];//dp[i][j]表示 前i张牌 和为j 共产生 的 damage 值。

        for (int j = 0; j <= totalMoney ; j++) {
            dp[0][j] = 0;//0 张牌 产生 0的damage。
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalMoney; j++) {
                dp[i][j] =  dp[i-1][j];
                if (j - cost[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - cost[i-1]] + damage[i-1]);
                }
            }
        }
        return dp[n][totalMoney] >= totalDamage;
    }
}
