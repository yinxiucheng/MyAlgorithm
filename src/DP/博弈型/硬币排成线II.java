package DP.博弈型;


/**
 * 395 · 硬币排成线 II
 * https://www.lintcode.com/problem/395
 *
 * 描述
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从 左边 依次拿走 1 或 2 个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
 *
 * 请判定 先手玩家 必胜还是必败?
 *
 * 若必胜, 返回 true, 否则返回 false.
 *
 */
public class 硬币排成线II {

    public boolean firstWillWin(int n) {
        if (n <= 2){
            return true;
        }
        return true;
    }
}
