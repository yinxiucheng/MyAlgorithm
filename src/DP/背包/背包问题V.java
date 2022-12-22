package DP.背包;

/**
 *
 * https://www.lintcode.com/problem/563/
 *
 * 描述
 * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品只能使用一次
 */
public class 背包问题V {

    public int backPackV(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;

        int[][] dp = new int[n+1][target + 1];

        for (int j = 0; j <= target ; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i - 1] >= j){
                    dp[i][j] += dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[n][target];
    }
}
