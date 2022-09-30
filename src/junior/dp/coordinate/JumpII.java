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
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class JumpII {
    /**
     * @param a: A list of integers
     * @return: An integer
     */
    public int jump(int[] a) {

        int n = a.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n ; i++) {
            int minJumps = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MAX_VALUE){
                    continue;
                }else {
                    if (a[j] >= i - j){
                        minJumps = Math.min(minJumps, dp[j] + 1);
                    }
                }
            }
            dp[i] = minJumps;
        }

        if (dp[n - 1] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[n-1];
    }
}
