package senior.dp.背包型;

/**
 * 564 · 组合总和 IV
 *
 * https://www.lintcode.com/problem/564/description?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 *
 */
public class 组合总和IV {

    public int backPackVI(int[] nums, int target) {
        int len = nums.length;

        int[] dp = new int[target + 1];//dp[i] 表示组成为和为 i 的 方案数。
        dp[0] = 1;

        for (int i = 1; i <= target ; i++) {
            dp[i] = 0;
            for (int j = 0; j < len; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];


        //todo 有顺序的做法。
//        //dp[i][j] 表示 前i个数组成和为j 的方案数。
//        int[][] dp = new int[len + 1][target + 1];
//
//        for (int i = 0; i <= len; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= len; i++) {
//            for (int j = 0; j <= target ; j++) {
//                dp[i][j] = dp[i-1][j];//第i 个数不选。
//                if (j >= nums[i-1]){
//                    dp[i][j] += dp[i][j-nums[i-1]];
//                }
//            }
//        }
//        return dp[len][target];
    }
}
