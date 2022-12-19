package DP.博弈型;


/**
 * 394 · 硬币排成线
 * https://www.lintcode.com/problem/394
 *
 * 描述
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 *
 * 请判定 先手玩家 必胜还是必败?
 *
 * 若必胜, 返回 true, 否则返回 false.
 *
 */
public class 硬币排成线 {

    public boolean firstWillWin(int n) {
        if (n <= 2){
            return true;
        }

        return false;
    }
}
