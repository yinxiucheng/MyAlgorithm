package junior.dp.coordinate;

/**
 * 117 · 跳跃游戏 II
 *
 * https://www.lintcode.com/problem/117
 *
 * 描述
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 *
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 *
 * 判断你是否能到达数组的最后一个位置。
 */
public class JumpI {

    /**
     * @param a: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] a) {

        int n = a.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]){
                    continue;
                }else {
                    if (a[j] >= i - j){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];
    }
}
