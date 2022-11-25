package senior.dp.二进制;

/**
 * 664 · 数 1
 *
 * https://www.lintcode.com/problem/664/
 *
 */
public class 数1 {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num ; i++) {
            dp[i] = dp[i>>1] + i%2;
        }
        return dp;
    }
}
