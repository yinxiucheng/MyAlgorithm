package senior.dp.坐标型;

/**
 * https://www.lintcode.com/problem/116/
 */
public class 跳跃游戏 {

    public boolean canJump(int[] a) {
        // write your code here
        int n = a.length;
        boolean[] dp = new boolean[n];//dp[i] 表示青蛙能否调到 第 i 块石头。
        dp[0] = true;

        for (int j = 1; j < n ; j++) {
            for (int i = 0; i < n; i++) {
                if (dp[i] && a[i] + i >= j){
                    dp[j] = true;
                }
            }
        }
        return dp[n-1];
    }
}
